package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.ViewModel;

import javax.jdo.annotations.NotPersistent;
import java.util.List;

/**
 * Created by jonathan on 29-7-15.
 */
@ViewModel
public class ProductSearchViewModel {







    //region > products (property)
    private List<Product> products;

    @MemberOrder(sequence = "1")
    @PropertyLayout(named = "Producten")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }
    //endregion


    //region > productElements (property)
    private List<ProductElement> productElements;

    @MemberOrder(sequence = "2")
    public List<ProductElement> getProductElements() {
        return productElements;
    }

    public void setProductElements(final List<ProductElement> productElements) {
        this.productElements = productElements;
    }
    //endregion


}
