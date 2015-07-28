package domainapp.dom.modules.stockpilemanagement.product;

import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import domainapp.dom.util.StorePredicates;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 14-7-15.
 */

@DomainService(repositoryFor = Product.class, nature = NatureOfService.DOMAIN)
public class Products implements ProductsInterface{



    @Programmatic
    public List<Product> listAll() {

        return container.allInstances(Product.class);
    }




    @Programmatic
    public List<Product> findByTitle(String title){

        return container.allMatches(Product.class, StorePredicates.ProductPredicate.thoseWithTitle(title));

    }

    @Programmatic
    public List<Product> findByDescriptionContains(String text){

        return container.allMatches(Product.class, StorePredicates.ProductPredicate.thoseWithDescriptionContains(text));

    }

    //region > createProduct (action)
    @Programmatic
    public Product createProduct(final String title, final String description) {

        Product p = container.newTransientInstance(Product.class);
        p.setTitle(title);
        p.setDescription(description);

        container.persist(p);
        return p;
    }
    //endregion

    @Programmatic
    public void removeProduct(Product product){

        List<Stock> stocksWithProduct = stocks.findByProduct(product);
        for(Stock s: stocksWithProduct){
            stocks.removeStock(s);
        }
        container.removeIfNotAlready(product);

    }



    @Inject
    Stocks stocks;

    @Inject
    DomainObjectContainer container;

}
