package domainapp.dom.modules.store;

import com.google.common.collect.Lists;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementText;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 4-8-15.
 */

@DomainService
public class ProductSearchService {


    //region > findProducts (action)
    @MemberOrder(sequence = "1")
    public List<Product> findProducts() {

        Product p = products.createProduct("Een product", "Dit is een product");

        ProductElementText pe = productElements.createProductElementText(p, "Kleur", "Rood");

        ArrayList<ProductElement> l = new ArrayList<>();
        l.add(pe);
        return products.findByProductElements(l);



    }
    //endregion



    @Inject
    Products products;

    @Inject
    ProductElements productElements;

}
