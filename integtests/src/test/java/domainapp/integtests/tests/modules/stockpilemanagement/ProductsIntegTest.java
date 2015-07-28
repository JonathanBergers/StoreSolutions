package domainapp.integtests.tests.modules.stockpilemanagement;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import domainapp.fixture.modules.TeardownFixture;
import domainapp.fixture.modules.stockpilemanagement.ProductsFixture;
import domainapp.integtests.tests.SimpleAppIntegTest;
import org.junit.*;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by jonathan on 27-7-15.
 */
public class ProductsIntegTest  extends SimpleAppIntegTest {
    @Inject
    Products products;



    @Inject
    Stocks stocks;

    protected final String CREATE_TITLE = "IntegratieTestProduct";
    protected final String DESCRIPTION = ProductsFixture.PRODUCT_DESCRIPTION + CREATE_TITLE;
    protected final String FIRST_PRODUCT_TITLE = ProductsFixture.NAMES.get(0);
    protected final String FIRST_PRODUCT_DESCRIPTION = ProductsFixture.PRODUCT_DESCRIPTION + FIRST_PRODUCT_TITLE;


    @Before
    public void setUp() throws Exception {
        scenarioExecution().install(new TeardownFixture());
        scenarioExecution().install(new ProductsFixture());
    }






    public static class createProduct extends ProductsIntegTest{
        @Test
        public void createProductTest() {


            List<Product> productList = products.listAll();
            assertNotNull(productList);
            assertFalse(productList.isEmpty());

            int sizeBefore = productList.size();

            Product p = products.createProduct(CREATE_TITLE, DESCRIPTION);

            assertNotNull(p);
            assertThat(sizeBefore + 1, is(products.listAll().size()));


        }


    }
    public static class findByTitle extends ProductsIntegTest {
        @Test
        public void findByTitleTest() {


            List<Product> pList = products.findByTitle(FIRST_PRODUCT_TITLE);

            assertFalse(pList.isEmpty());
            Product p = pList.get(0);
            assertNotNull(p);

            assertThat(p.getTitle(), is(FIRST_PRODUCT_TITLE));
            assertThat(p.getDescription(), is(FIRST_PRODUCT_DESCRIPTION));


        }

    }

    public static class findByDescriptionContains extends ProductsIntegTest {


        @Test
        public void findByDescriptionContainsTest() {
            String descriptionpart = FIRST_PRODUCT_DESCRIPTION.substring(FIRST_PRODUCT_DESCRIPTION.length() - 10, FIRST_PRODUCT_DESCRIPTION.length());


            List<Product> pList = products.findByDescriptionContains(descriptionpart);

            assertFalse("empty list, " + pList.size(), pList.isEmpty());
            Product p = pList.get(0);
            assertNotNull(p);

            assertThat(p.getTitle(), is(FIRST_PRODUCT_TITLE));
            assertThat(p.getDescription(), is(FIRST_PRODUCT_DESCRIPTION));


        }


        public static class removeProduct extends ProductsIntegTest {


            @Test
            public void removeProductTest() {

                List<Product> allProducts = products.listAll();
                assertFalse(allProducts.isEmpty());
                for (Product p : allProducts) {

                    products.removeProduct(p);
                }

                allProducts = products.listAll();
                assertTrue(allProducts.isEmpty());


                //omdat constrains, stocks worden verwijderd als product wordt verwijderd.
                assertTrue(stocks.listAll().isEmpty());


            }

        }
    }








}
