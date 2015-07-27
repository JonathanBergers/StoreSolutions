package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 14-7-15.
 */

@DomainService(repositoryFor = Product.class, nature = NatureOfService.DOMAIN)
public class Products {



    @Programmatic
    public List<Product> listAll() {

        return container.allInstances(Product.class);
    }


    @Programmatic
    public List<Product> findByTitle(String title){

        return container.allMatches(Product.class, Predicates.ProductPredicate.thoseWithTitle(title));

    }

    @Programmatic
    public List<Product> findByDescriptionContains(String text){

        return container.allMatches(Product.class, Predicates.ProductPredicate.thoseWithDescriptionContains(text));

    }

    //region > createProduct (action)
    @Programmatic
    public Product createProduct(final String title, final String description) {

        Product p = container.newTransientInstance(Product.class);
        p.setTitle(title);
        p.setDescription(description);
        container.persist(p);
        return p;
    }
    //endregion





    @Inject
    DomainObjectContainer container;

}
