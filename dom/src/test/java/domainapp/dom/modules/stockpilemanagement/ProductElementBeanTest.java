package domainapp.dom.modules.stockpilemanagement;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementNumeric;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementText;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import org.junit.Test;

/**
 * Created by jonathan on 4-8-15.
 */
public class ProductElementBeanTest {

    public static class TextBeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final ProductElementText stock = new ProductElementText();
            newPojoTester()
                    .withFixture(pojos(Product.class, ProductForTesting.class))
                    .exercise(stock);


        }

    }

    public static class NumericBeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final ProductElementNumeric stock = new ProductElementNumeric();
            newPojoTester()
                    .withFixture(pojos(Product.class, ProductForTesting.class))
                    .exercise(stock);


        }

    }



}
