package domainapp.integtests.tests.modules.stock;

import domainapp.dom.modules.store.stock.Product;
import domainapp.dom.modules.store.stock.Products;
import domainapp.fixture.modules.StoreFixtureScript;
import domainapp.integtests.tests.SimpleAppIntegTest;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jonathan on 23-7-15.
 */
public class ProductIntegTest extends SimpleAppIntegTest {


    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    DomainObjectContainer container;



    @Before
    public void setUp() throws Exception {

        scenarioExecution().install(new StoreFixtureScript());


    }

    public static class createProductTest extends ProductIntegTest {


        @Inject
        Products products;

        private final String TITLE = "Titel";


        @Test
        public void createProduct(){

            List<Product> productList = products.listAll();
            assertNotNull(productList);
            assertFalse(productList.isEmpty());

            int sizeBefore = productList.size();

            Product p = products.createProduct(TITLE, BigDecimal.TEN, BigDecimal.ONE);

            assertNotNull(p);
            assertThat(sizeBefore + 1,is(products.listAll().size()));




        }



    }





}
