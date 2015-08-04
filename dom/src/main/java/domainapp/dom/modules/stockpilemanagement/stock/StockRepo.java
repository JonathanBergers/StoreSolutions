package domainapp.dom.modules.stockpilemanagement.stock;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY)
@DomainServiceLayout(named = "Voorraadbeheer", menuBar = DomainServiceLayout.MenuBar.PRIMARY)
public class StockRepo{



    private enum SearchType{

        GELIJK_AAN,
        MINDER_DAN,
        MEER_DAN;
    }

    @Inject
    Stocks stocks;


    @Action
    @ActionLayout(named = "Voorraden zoeken")
    @MemberOrder(sequence = "2")
    public List<Stock> findByAmount(@ParameterLayout(named = "Methode")final SearchType type, @ParameterLayout(named = "Hoeveelheid")final Integer amount){

        switch (type){

            case GELIJK_AAN: return stocks.findByAmount(amount);
            case MINDER_DAN: return stocks.findByAmountLessThan(amount);
            case MEER_DAN: return stocks.findByAmountMoreThan(amount);
        }
        return stocks.findByAmount(amount);

    }

    //region > listAll (action)
    @Action
    @ActionLayout(named = "Alle voorraden")
    @MemberOrder(sequence = "1")
    public List<Stock> listAll() {
        return stocks.listAll();
    }
    //endregion

    public SearchType default0FindByAmount() {
        return SearchType.GELIJK_AAN;
    }



}
