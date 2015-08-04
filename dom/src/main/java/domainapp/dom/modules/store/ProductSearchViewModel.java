package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementText;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import javax.jdo.annotations.NotPersistent;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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

    public ProductSearchViewModel(SortedSet<ProductElement> productElements) {
        this.productElements = productElements;
    }





    //region > products (property)
    private List<Product> products;

    @MemberOrder(sequence = "2")
    @CollectionLayout(named = "Gevonden producten")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    //endregion


    //region > productElements (property)
    private SortedSet<ProductElement> productElements = new TreeSet<>();

    @MemberOrder(sequence = "1")
    @CollectionLayout(named = "Filters")
    public SortedSet<ProductElement> getProductElements() {
        return productElements;
    }

    public void setProductElements(final SortedSet<ProductElement> productElements) {
        this.productElements = productElements;
    }

//    private void addProductElement(final ProductElement productElement){
//        productElements.add(productElement);
//    }
//    //endregion

    //region > addElement (action)
    @MemberOrder(sequence = "1")
    @Action
    @ActionLayout(named = "Bestaand text attribuut")
    public ProductSearchViewModel addTextElement(final Product product, @ParameterLayout(named = "Soort")final String type,
                                         @ParameterLayout(named = "Waarde")final String value){


        ProductElementText pe = createProductElementText(product, type,value);
        productElements.add(pe);
        return new ProductSearchViewModel(getProductElements());

    }

    @Programmatic
    public ProductElementText createProductElementText(Product product, final String type, final String value) {
        ProductElementText e = container.newTransientInstance(ProductElementText.class);
        e.setProduct(product);
        e.setType(type);
        e.setValue(value);
        e.setDisplayValue(value);

        return e;
    }

    @Inject
    ProductElements productElementsInject;
    @Inject
    DomainObjectContainer container;


}
