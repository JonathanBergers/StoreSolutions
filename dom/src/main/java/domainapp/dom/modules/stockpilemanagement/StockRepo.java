package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY)
public class StockRepo implements StockRepoInterface{




    @Inject
    Stocks stocks;

    @Override
    public List<Stock> listAll() {
        return stocks.listAll();
    }

    @Override
    public List<Stock> findByProduct(Product product) {
        return stocks.findByProduct(product);
    }

    @Override
    public List<Stock> findByAmount(Integer amount) {
        return stocks.findByAmount(amount);
    }

    @Override
    public List<Stock> findByAmountLessThan(Integer amount) {
        return stocks.findByAmountLessThan(amount);
    }

    @Override
    public List<Stock> findByAmountMoreThan(Integer amount) {
        return stocks.findByAmountMoreThan(amount);
    }
}
