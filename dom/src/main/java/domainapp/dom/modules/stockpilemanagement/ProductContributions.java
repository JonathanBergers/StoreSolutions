package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ProductContributions {


    //region > remove (action)
    @Action
    public void remove(Product product, final boolean sure) {
        if(sure){
            container.remove(product);}
    }
    //endregion



    @Inject
    DomainObjectContainer container;

    @Inject
    Stocks stocks;
}
