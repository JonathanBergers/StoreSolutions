package domainapp.dom.modules.stockpilemanagement.product.element;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import org.apache.isis.applib.annotation.ActionLayout;

import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
public interface ProductElementsInterface {


    public <T extends  ProductElement<T>> List<T> listAll(Class<T> childClass);

    public <T extends  ProductElement<T>> List<T> findByType(Class<T> childClass, String type);

    public <T extends  ProductElement<T>> List<T> findByTypeContains(Class<T> childClass, String type);

    public <T extends  ProductElement<T>> List<T> findByTypeStartswith(Class<T> childClass, String type);

    public <T extends  ProductElement<T>> List<T> findByProduct(Class<T> childClass, Product product);



    public List<ProductElement> listAll();
//
    public List<ProductElement> findByType(String type);
//
    public List<ProductElement> findByTypeContains(String type);

    public List<ProductElement> findByTypeStartswith(String type);
//
    public List<ProductElement> findByProduct(Product product);




    public ProductElementText createProductElementText(Product product, final String type, final String value);

    public ProductElementNumeric createProductElementNumeric(Product product, final String type, final ProductElementEntity entity, final int value);






}
