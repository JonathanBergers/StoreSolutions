package domainapp.dom.modules.stockpilemanagement;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import org.junit.Test;

/**
 * Created by jonathan on 23-7-15.
 */
public class ProductBeanTest {




    public static class BeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final ProductForTesting product = new ProductForTesting();
            newPojoTester()
                    .exercise(product);



        }

    }





}
