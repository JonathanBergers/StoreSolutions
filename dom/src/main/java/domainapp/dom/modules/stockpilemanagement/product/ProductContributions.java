package domainapp.dom.modules.stockpilemanagement.product;

import com.google.common.collect.Lists;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementText;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.Collection;

import javax.inject.Inject;
import java.util.*;

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


    //region > addElement (action)
    @MemberOrder(sequence = "1")
    @Action
    public ProductElement addElementText(final Product product, final String type, final String value){


        return productElements.createProductElementText(product, type, value);

    }


    public List<String> autoComplete1AddElementText(final String search) {
        List<String> types = new ArrayList<>();
        for(ProductElementText p: productElements.findTextByTypeContains(search)){
            types.add(p.getType());
        }
        return types;
    }
    //TODO, tags ??



    //endregion



    @Inject
    DomainObjectContainer container;

    @Inject
    Stocks stocks;

    @Inject
    Products products;

    @Inject
    ProductElements productElements;
}
