package domainapp.dom.modules.stockpilemanagement.product;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */

public class ProductRepo implements ProductRepoInterface<Product> {


    @Override
    @ActionLayout(named = "Alle producten")
    public List<Product> listAll() {
        return products.listAll();
    }

    @Override
    @ActionLayout(named = "Zoek op titel")
    public List<Product> findByTitle(final String title) {
        return products.findByTitle(title);
    }

    @Override
    @ActionLayout(named = "Zoek in beschrijving")
    public List<Product> findByDescriptionContains(final String text) {
        return products.findByDescriptionContains(text);
    }

    @Inject
    DomainObjectContainer container;

    @Inject
    Products products;
}
