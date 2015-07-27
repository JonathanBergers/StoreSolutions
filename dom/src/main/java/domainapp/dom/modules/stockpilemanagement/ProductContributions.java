package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import javax.jdo.annotations.NotPersistent;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ProductContributions {


    //region > remove (action)
    @Action
    public void remove(Product product, final boolean sure) {
        if(sure) {
        products.removeProduct(product);}
    }
    //endregion


    @Action
    @Collection(notPersisted = true)
    @CollectionLayout(render =  RenderType.EAGERLY)
    public List<Stock> collectStock(Product product){
        return stocks.findByProduct(product);

    }





    @Inject
    DomainObjectContainer container;

    @Inject
    Stocks stocks;

    @Inject
    Products products;
}
