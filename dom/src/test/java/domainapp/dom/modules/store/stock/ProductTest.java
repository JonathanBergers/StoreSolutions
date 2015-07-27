package domainapp.dom.modules.store.stock;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by jonathan on 23-7-15.
 */
public class ProductTest {




    public static class BeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final ProductForTesting product = new ProductForTesting();
            newPojoTester()
                    .exercise(product);










            assert product != null: "product null";


        }

    }





}
