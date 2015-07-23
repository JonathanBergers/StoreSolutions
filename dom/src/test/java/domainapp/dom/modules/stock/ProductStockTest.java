package domainapp.dom.modules.stock;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import domainapp.dom.modules.store.stock.Product;
import domainapp.dom.modules.store.stock.ProductStock;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by jonathan on 23-7-15.
 */
public class ProductStockTest {




    public static class BeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final ProductStock ps = new ProductStock();
            newPojoTester()
                    .withFixture(pojos(Product.class, ProductForTesting.class))
                            .exercise(ps);



            ps.setAmount(10);

            assert ps.getAmount() == 10;





        }

    }
}
