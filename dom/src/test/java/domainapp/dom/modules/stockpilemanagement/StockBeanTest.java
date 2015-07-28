package domainapp.dom.modules.stockpilemanagement;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import org.junit.Test;

/**
 * Created by jonathan on 27-7-15.
 */
public class StockBeanTest {


    public static class BeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final Stock stock = new Stock();
            newPojoTester()
                    .withFixture(pojos(Product.class, ProductForTesting.class))
                    .exercise(stock);



        }

    }
}
