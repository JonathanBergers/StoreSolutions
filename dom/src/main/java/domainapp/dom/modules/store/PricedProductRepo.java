package domainapp.dom.modules.store;

import domainapp.dom.util.StorePredicates;
import domainapp.dom.modules.stockpilemanagement.product.ProductRepo;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import javax.inject.Inject;
import javax.xml.ws.Action;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY)
public class PricedProductRepo extends ProductRepo{


    @Action
    public List<PricedProduct> findByCostPrice(final BigDecimal costPrice){

        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithCostPrice(costPrice));
    }



    @Inject
    DomainObjectContainer container;
}
