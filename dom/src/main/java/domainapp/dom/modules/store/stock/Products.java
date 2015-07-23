package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.inject.Inject;
import javax.xml.ws.Action;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 14-7-15.
 */

@DomainService(repositoryFor = Product.class)
public class Products {



    //region > createProduct (action)
    @MemberOrder(sequence = "1")
    @Action
    public Product createProduct(final String title, final BigDecimal sellingPrice, final BigDecimal costPrice) {

        Product p = container.newTransientInstance(Product.class);
        p.setTitle(title);
        p.setSellingPrice(sellingPrice);
        p.setCostPrice(costPrice);

        container.persist(p);
        return p;

    }
    //endregion


    //region > listAll (action)
    @MemberOrder(sequence = "1")
    @Action
    public List<Product> listAll() {

        return container.allInstances(Product.class);
    }
    //endregion






    @Inject
    DomainObjectContainer container;

}
