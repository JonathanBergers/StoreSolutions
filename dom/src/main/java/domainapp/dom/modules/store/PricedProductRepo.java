package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.Predicates;
import domainapp.dom.modules.stockpilemanagement.ProductRepo;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;

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

        return container.allMatches(PricedProduct.class, Predicates.PricedProductPredicate.thoseWithCostPrice(costPrice));
    }

    @Inject
    DomainObjectContainer container;
}
