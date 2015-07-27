package domainapp.fixture.modules.stockpilemanagement;


import domainapp.dom.modules.stockpilemanagement.Product;
import domainapp.dom.modules.stockpilemanagement.ProductContributions;
import domainapp.dom.modules.stockpilemanagement.Products;
import domainapp.dom.modules.stockpilemanagement.Stocks;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 20-7-15.
 */
public class StockFixture extends FixtureScript {



    @Override
    protected void execute(ExecutionContext executionContext) {


        List<Product> productlist = products.listAll();

        for(Product p: productlist){

            int amount = 6 +  (int) (Math.random() * 15);
            stocks.createStock(p, amount);
        }



    }


    @Inject
    Stocks stocks;


    @Inject
    Products products;
}
