package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;

import javax.inject.Inject;

/**
 * Created by jonathan on 14-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ProductContributions {



    //region > addStock (action)
    @MemberOrder(sequence = "1")
    public ProductStock addStock(final Product product, final int amount) {

        ProductStock ps = container.newTransientInstance(ProductStock.class);
        ps.setAmount(amount);
        ps.setItem(product);
        container.persist(ps);


        return ps;
    }

    //endregion
    @Inject
    DomainObjectContainer container;





}
