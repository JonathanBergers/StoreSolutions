package domainapp.dom.modules.store;

import domainapp.dom.util.SearchTypes;
import domainapp.dom.modules.stockpilemanagement.product.ProductRepo;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY)
@DomainServiceLayout(named = "Voorraadbeheer", menuBar = DomainServiceLayout.MenuBar.PRIMARY)
public class PricedProductRepo extends ProductRepo{



    @Action
    @ActionLayout(named = "Prijs")
    @MemberOrder(sequence = "3")
    public List<PricedProduct> findByPrice(@ParameterLayout(named = "Prijs type" )final SearchTypes.Price type ,
                                               @ParameterLayout(named = "Prijs")final BigDecimal price){

        switch (type){
            case KOST_PRIJS: return pricedProducts.findByCostPrice(price);
            case VERKOOP_PRIJS: return pricedProducts.findBySellingPrice(price);
        }
        return pricedProducts.findBySellingPrice(price);
    }

    public SearchTypes.Price default0FindByPrice() {
        return SearchTypes.Price.VERKOOP_PRIJS;
    }


    @Action
    @ActionLayout(named = "Uitgebreid zoeken")
    @MemberOrder(sequence = "4")
    public SearchRequest findByExtended(){

        SearchRequest s  = container.newTransientInstance(SearchRequest.class);
        s.setUsername(container.getUser().getName());
        container.persistIfNotAlready(s);
        return s;
    }


    @Inject
    DomainObjectContainer container;

    @Inject
    PricedProducts pricedProducts;
}
