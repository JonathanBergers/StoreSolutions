package domainapp.dom.modules.stockpilemanagement.product.element;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import org.apache.isis.applib.annotation.ActionLayout;

import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
public interface ProductElementsInterface {



    public ProductElementText createProductElementText(Product product, final String type, final String value);

    public ProductElementNumeric createProductElementNumeric(Product product, final String type, final ProductElementEntity entity, final int value);

    //text

    public List<ProductElementText> listAllText();

    public List<ProductElementText> findByTypeText(String type);

    public List<ProductElementText> findByTypeContainsText(String type);

    // product element

    public List<ProductElement> findByProduct(Product product);

    public List<ProductElement> listAll();

    public List<ProductElement> findByType(String type);

    //numeric

    public List<ProductElementNumeric> listAllNumeric();


}
