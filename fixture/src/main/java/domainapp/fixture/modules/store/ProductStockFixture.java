package domainapp.fixture.modules.store;

import domainapp.dom.modules.store.stock.Product;
import domainapp.dom.modules.store.stock.ProductContributions;
import domainapp.dom.modules.store.stock.Products;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 20-7-15.
 */
public class ProductStockFixture extends FixtureScript{


    public ProductStockFixture() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(ExecutionContext executionContext) {


        List<Product> productlist = products.listAll();

        for(Product p: productlist){

            int amount = 6 +  (int) (Math.random() * 15);
            productContributions.addStock(p, amount);
        }



    }


    @Inject
    ProductContributions productContributions;


    @Inject
    Products products;
}
