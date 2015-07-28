package domainapp.fixture.modules.stockpilemanagement;

import domainapp.dom.modules.store.PricedProduct;
import domainapp.dom.modules.store.PricedProducts;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by jonathan on 28-7-15.
 */
public class PricedProductsFixture extends ProductsFixture {


    @Inject
    PricedProducts products;


    @Override
    protected void execute(ExecutionContext executionContext) {

            assert products.listAll().isEmpty();

            for(String s: NAMES){


                BigDecimal costPrice = BigDecimal.valueOf(5);
                BigDecimal sellingPrice = BigDecimal.valueOf(10);

                PricedProduct p = products.createPricedProduct(s, PRODUCT_DESCRIPTION + s, costPrice, sellingPrice);
                executionContext.addResult(this, p);
            }



    }
}
