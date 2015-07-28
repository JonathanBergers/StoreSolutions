package domainapp.dom.modules.stockpilemanagement.stock;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.util.StorePredicates;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(repositoryFor = Stock.class, nature = NatureOfService.DOMAIN)
public class Stocks {


    //region > createStock (action)
    @Programmatic
    public Stock createStock(final Product product, final Integer amount) {

        Stock s = container.newTransientInstance(Stock.class);
        s.setProduct(product);
        s.setAmount(amount);
        container.persistIfNotAlready(s);
        return s;
    }
    //endregion


    //region > listAllText (action)
    @Programmatic
    public List<Stock> listAll() {
        return container.allInstances(Stock.class);
    }
    //endregion

    //region > findByProduct (action)
    @Programmatic
    public List<Stock> findByProduct(final Product product) {
        return container.allMatches(Stock.class, StorePredicates.StockPredicate.thoseWithProduct(product));
    }
    //endregion


    //region > findByAmount (action)
    @Programmatic
    public List<Stock> findByAmount(final Integer amount) {
        return container.allMatches(Stock.class, StorePredicates.StockPredicate.thoseWithAmount(amount));
    }
    //endregion

    //region > findByAmountLessThan (action)
    @Programmatic
    public List<Stock> findByAmountLessThan(final Integer amount) {
        return container.allMatches(Stock.class, StorePredicates.StockPredicate.thoseWithAmountLessThan(amount));
    }
    //endregion


    //region > findByAmountLessThan (action)
    @Programmatic
    public List<Stock> findByAmountMoreThan(final Integer amount) {
        return container.allMatches(Stock.class, StorePredicates.StockPredicate.thoseWithAmountMoreThan(amount));
    }
    //endregion


    //region > removeStock (action)
    @Programmatic
    public void removeStock(final Stock stock) {
        container.removeIfNotAlready(stock);
    }
    //endregion

    @Inject
    DomainObjectContainer container;

}
