package domainapp.dom.modules.stock;

import domainapp.dom.modules.AbstractBeanPropertiesTest;
import domainapp.dom.modules.store.stock.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by jonathan on 23-7-15.
 */
public class ProductTest {




    public static class BeanProperties extends AbstractBeanPropertiesTest {

        @Test
        public void test() {
            final Product product = new Product();
            newPojoTester()
                    .exercise(product);


            product.setCostPrice(BigDecimal.ONE);
            product.setSellingPrice(BigDecimal.TEN);






            assert product != null: "product null";
            assert product.getCostPrice().equals(BigDecimal.ONE);
            assert product.getSellingPrice().equals(BigDecimal.TEN);



        }

    }





}
