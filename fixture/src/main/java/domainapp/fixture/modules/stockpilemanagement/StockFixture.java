package domainapp.fixture.modules.stockpilemanagement;


import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
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

        assert productlist.size() ==10: "size = " + productlist.size();


        int amount = 0;
        for(Product p: productlist){

            amount ++;
           executionContext.addResult(this, stocks.createStock(p, amount));
        }



    }


    @Inject
    Stocks stocks;


    @Inject
    Products products;
}
