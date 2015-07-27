package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY)
public class ProductRepo implements ProductRepoInterface<Product> {


    @Override
    public List<Product> listAll() {
        return products.listAll();
    }

    @Override
    public List<Product> findByTitle(String title) {
        return products.findByTitle(title);
    }

    @Override
    public List<Product> findByDescriptionContains(String text) {
        return products.findByDescriptionContains(text);
    }

    @Inject
    DomainObjectContainer container;

    @Inject
    Products products;
}
