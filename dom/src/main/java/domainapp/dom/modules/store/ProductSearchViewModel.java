package domainapp.dom.modules.store;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementText;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 29-7-15.
 */
@ViewModel
public class ProductSearchViewModel {


    public String title(){
        return "Uitgebreid zoeken (nog niet werkend)";
    }

    public ProductSearchViewModel() {
    }


    public ProductSearchViewModel(List<ProductElement> productElements) {
        this.productElements = productElements;
    }

    //region > products (property)
    private List<Product> products = new ArrayList<>();

    @MemberOrder(sequence = "2")
    @CollectionLayout(named = "Gevonden producten",render = RenderType.EAGERLY)
    public List<Product> getProducts() {
        return productsInject.findByProductElements(getProductElements());

    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }



    //endregion


    //region > productElements (property)
    private List<ProductElement> productElements = new ArrayList<>();

    @MemberOrder(sequence = "1")
    @CollectionLayout(named = "Filters", render = RenderType.EAGERLY)
    public List<ProductElement> getProductElements() {
        return productElements;
    }

    public void setProductElements(final List<ProductElement> productElements) {
        this.productElements = productElements;
    }
    //endregion





    // ---- ADD ELEMENT --------------//

    //region > addElement (action)
    @MemberOrder(sequence = "1")
    @Action
    @ActionLayout(named = "Bestaand text attribuut")
    public ProductSearchViewModel addTextElement(@ParameterLayout(named = "Soort")final String type,
                                         @ParameterLayout(named = "Waarde") final ProductElement element){





        productElements.add(element);
        //search();

        return new ProductSearchViewModel(getProductElements());

    }

    public Set<String> choices0AddTextElement() {
        return getTypesFromElements(productElementsInject.listAll());
    }


    public Set<ProductElement> choices1AddTextElement(final String type) {

        if(type == null){
            return new TreeSet<ProductElement>();
        }
        return Sets.newTreeSet(productElementsInject.findByType(type));
    }



    @Programmatic
    private SortedSet<String> getTypesFromElements(List<? extends ProductElement> elements){

        SortedSet<String> types = elements.stream().map(ProductElement::getType).collect(Collectors.toCollection(() -> new TreeSet<>()));
        return types;
    }



        // ====== ADD ELEMENT ============//









    @Programmatic
    public ProductElementText createProductElementText(Product product, final String type, final String value) {
        ProductElementText e = new ProductElementText();
        e.setProduct(product);
        e.setType(type);
        e.setValue(value);
        e.setDisplayValue(value);

        return e;
    }


    @Programmatic
    private void search(){

        setProducts(productsInject.findByProductElements(getProductElements()));

    }

    @Inject
    ProductElements productElementsInject;

    @Inject
    Products productsInject;

    @Inject
    DomainObjectContainer container;


}
