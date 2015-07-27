package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;

import javax.inject.Inject;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class StockContributions {

    //region > remove (action)
    @Action
    public void remove(Stock stock, final boolean sure) {
        if(sure){
            container.remove(stock);}
    }
    //endregion


    @Inject
    DomainObjectContainer container;
}
