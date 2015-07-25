package domainapp.dom.modules.store.stock;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import domainapp.dom.modules.stockpilemanagement.Stock;
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


            product.setCostPrice(BigDecimal.ONE);
            product.setSellingPrice(BigDecimal.TEN);







            assert product != null: "product null";
            assert product.getCostPrice().equals(BigDecimal.ONE): "cost price incorrect";
            assert product.getSellingPrice().equals(BigDecimal.TEN): "selling price incorrect";



        }

    }





}
