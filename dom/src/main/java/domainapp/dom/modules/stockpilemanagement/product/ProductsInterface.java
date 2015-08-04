package domainapp.dom.modules.stockpilemanagement.product;

import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.util.StorePredicates;
import org.apache.isis.applib.annotation.Programmatic;

import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
public interface ProductsInterface {


    public List<Product> listAll();

    public List<Product> findByTitle(final String title);

    public List<Product> findByDescriptionContains(final String text);

    public List<Product> findByProfileElements(List<ProductElement> productElements);


    public List<Product> findByTitleContains(String title);


}
