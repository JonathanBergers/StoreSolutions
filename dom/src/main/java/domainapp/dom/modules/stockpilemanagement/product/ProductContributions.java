package domainapp.dom.modules.stockpilemanagement.product;

import com.google.common.collect.Lists;
import domainapp.dom.modules.stockpilemanagement.product.element.*;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.Collection;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ProductContributions {


    public static final String ELEMENTS_GROUP = "Attributen";

    //region > remove (action)
    @Action
    @ActionLayout(named = "Verwijder")
    public void remove(Product product, @ParameterLayout(named = "Weet u het zeker?" )final boolean sure) {
        if(sure) {
        products.removeProduct(product);}
    }
    //endregion


    @MemberOrder(sequence = "1", name = "Stock")
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION, named = "Voorraad")
    @CollectionLayout(render = RenderType.EAGERLY)
    public List<Stock> collectStock(Product product){
        return stocks.findByProduct(product);

    }


    //region > addElement (action)

    @MemberOrder(sequence = "1", name = ELEMENTS_GROUP)
    @Action
    @ActionLayout(named = "Nieuw text attribuut", position = ActionLayout.Position.RIGHT)
    public Product newTextElement(final Product product, @ParameterLayout(named = "Soort")final String type,
                                         @ParameterLayout(named = "Waarde")final String value){

        productElements.createProductElementText(product, type, value);
        return product;

    }

    //region > addElement (action)
    @MemberOrder(sequence = "1", name = ELEMENTS_GROUP)
    @Action
    @ActionLayout(named = "Nieuw nummeriek attribuut", position = ActionLayout.Position.PANEL_DROPDOWN)
    public Product newNumericElement(final Product product, @ParameterLayout(named = "Soort")final String type,
                                            @ParameterLayout(named = "Waarde")final int value,
                                            @ParameterLayout(named = "Eenheid")final ProductElementEntity entity){

        productElements.createProductElementNumeric(product, type, entity, value);
        return product;

    }

    //region > addElement (action)
    @MemberOrder(sequence = "1", name = ELEMENTS_GROUP)
    @Action
    @ActionLayout(named = "Bestaand nummeriek attribuut", position = ActionLayout.Position.BELOW)
    public Product addNumericElement(final Product product, @ParameterLayout(named = "Soort")final String type,
                                            @ParameterLayout(named = "Waarde")final int value,
                                            @ParameterLayout(named = "Eenheid")final ProductElementEntity entity){

       productElements.createProductElementNumeric(product, type, entity, value);
        return product;

    }


    public SortedSet<String> choices1AddNumericElement() {
        return getTypesFromElements(productElements.listAll(ProductElementNumeric.class));
    }


    //region > addElement (action)
    @MemberOrder(sequence = "1", name = ELEMENTS_GROUP)
    @Action
    @ActionLayout(named = "Bestaand text attribuut", position = ActionLayout.Position.BELOW, describedAs = "Voeg een bestaand attribuut toe voor dit product")
    public Product addTextElement(final Product product, @ParameterLayout(named = "Soort")final String type,
                                         @ParameterLayout(named = "Waarde")final String value){

        productElements.createProductElementText(product, type, value);
        return product;

    }

    public SortedSet<String> choices1AddTextElement() {
        return getTypesFromElements(productElements.listAll(ProductElementText.class));
    }


    private SortedSet<String> getTypesFromElements(List<? extends ProductElement> elements){

        SortedSet<String> types = elements.stream().map(ProductElement::getType).collect(Collectors.toCollection(() -> new TreeSet<>()));
        return types;
    }


    @MemberOrder(sequence = "1", name = ELEMENTS_GROUP)
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    @CollectionLayout(render = RenderType.EAGERLY, named = "Attributen")
    public List<ProductElement> getElements(Product product){
        return productElements.findByProduct(product);
    }


    //region > createStock (action)
    @MemberOrder(sequence = "2", name = "Voorraad")
    @Action
    @ActionLayout(named = "Vooraad toevoegen")
    public Product createStock(Product product, @ParameterLayout(named = "Hoeveelheid")final Integer amount) {

        stocks.createStock(product, amount);
        return product;
    }
    //endregion




    //TODO, tags ??



    //endregion



    @Inject
    DomainObjectContainer container;

    @Inject
    Stocks stocks;

    @Inject
    Products products;

    @Inject
    ProductElements productElements;
}
