package domainapp.dom.modules.stockpilemanagement.product.element;

import domainapp.dom.modules.stockpilemanagement.product.Product;

import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
public interface ProductElementsInterface {



    public ProductElementText createProductElementText(Product product, final String type, final String value);

    public ProductElementNumber createProductElementNumber(Product product, final String type, final ProductElementEntity entity, final int value);

    public List<ProductElementText> listAllText();

    public List<ProductElementText> findTextByType(String type);

    public List<ProductElementText> findTextByTypeContains(String type);
}
