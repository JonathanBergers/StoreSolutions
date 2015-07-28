package domainapp.dom.modules.stockpilemanagement.product.element;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.util.StorePredicates;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
@DomainService(repositoryFor = ProductElement.class, nature = NatureOfService.DOMAIN)
public class ProductElements implements ProductElementsInterface {


    @Programmatic
    public ProductElementText createProductElementText(Product product, final String type, final String value) {
        ProductElementText e = container.newTransientInstance(ProductElementText.class);
        e.setProduct(product);
        e.setType(type);
        e.setValue(value);
        e.setDisplayValue(value);

        container.persistIfNotAlready(e);
        return e;
    }

    @Programmatic
    public ProductElementNumber createProductElementNumber(Product product, final String type, final ProductElementEntity entity, final int value) {

        ProductElementNumber e = container.newTransientInstance(ProductElementNumber.class);
        e.setProduct(product);
        e.setType(type);
        e.setEntity(entity);
        e.setValue(value);
        e.setDisplayValue(value + " " + entity);

        container.persistIfNotAlready(e);
        return e;
    }

    @Programmatic
    public List<ProductElementText> listAllText() {
        return container.allInstances(ProductElementText.class);
    }

    @Programmatic
    public List<ProductElementText> findTextByType(String type) {
        return container.allMatches(ProductElementText.class, StorePredicates.ProductElementPredicates.thoseWithType(type));
    }

    @Programmatic
    public List<ProductElementText> findTextByTypeContains(String type) {
        return container.allMatches(ProductElementText.class, StorePredicates.ProductElementPredicates.thoseWithTypeContains(type));
    }


    @Inject
    DomainObjectContainer container;

}
