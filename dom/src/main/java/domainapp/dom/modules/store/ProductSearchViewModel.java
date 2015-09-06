package domainapp.dom.modules.store;

import com.google.common.collect.Lists;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementText;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
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







    //region > products (property)
    private List<Product> products = new ArrayList<>();

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

//    private void addProductElement(final ProductElement productElement){
//        productElements.add(productElement);
//    }
//    //endregion

    //region > addElement (action)
    @MemberOrder(sequence = "1")
    @Action
    @ActionLayout(named = "Bestaand text attribuut")
    public ProductSearchViewModel addTextElement(@ParameterLayout(named = "Soort")final String type,
                                         @ParameterLayout(named = "Waarde")final String value){


        ProductElementText pe = createProductElementText(null, type,value);
        productElements.add(pe);
        search();
        return this;

    }



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
