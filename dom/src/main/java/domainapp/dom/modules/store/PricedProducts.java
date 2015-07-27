package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.Predicates;
import domainapp.dom.modules.stockpilemanagement.Product;
import domainapp.dom.modules.stockpilemanagement.Products;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
@DomainService
public class PricedProducts extends Products{


    //region > createProduct (action)
    @Programmatic
    public PricedProduct createPricedProduct(final String title, final String description, final BigDecimal costPrice, final BigDecimal sellingPrice) {

        PricedProduct p = container.newTransientInstance(PricedProduct.class);
        p.setTitle(title);
        p.setDescription(description);
        p.setCostPrice(costPrice);
        p.setSellingPrice(sellingPrice);


        container.persist(p);
        return p;
    }
    //endregion


    @Programmatic
    public List<PricedProduct> findByCostPrice(final BigDecimal costPrice){

        return container.allMatches(PricedProduct.class, Predicates.PricedProductPredicate.thoseWithCostPrice(costPrice));
    }

    @Inject
    DomainObjectContainer container;


}
