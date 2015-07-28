package domainapp.integtests.tests.modules.stockpilemanagement;


import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import domainapp.fixture.modules.TeardownFixture;
import domainapp.fixture.modules.stockpilemanagement.ProductsFixture;
import domainapp.fixture.modules.stockpilemanagement.StockFixture;
import domainapp.integtests.tests.SimpleAppIntegTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by jonathan on 27-7-15.
 */
public class StockIntegTest extends SimpleAppIntegTest{


    protected final Integer CREATE_AMOUNT = 99999;
    protected final String FIRST_PRODUCT_TITLE = ProductsFixture.NAMES.get(0);

    protected Product testProduct;


    @Inject
    Stocks stocks;
    @Inject
    Products products;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {


        scenarioExecution().install(new TeardownFixture());
        scenarioExecution().install(new ProductsFixture());
        scenarioExecution().install(new StockFixture());



    }

    @Before
    public void setUp(){

        testProduct = products.findByTitle(FIRST_PRODUCT_TITLE).get(0);
    }



   public static class createStock extends StockIntegTest{


       @Test
       public void createStockTest() {

           List<Stock> allStocks = stocks.listAll();
           assertFalse(allStocks.isEmpty());

           int sizeBefore = allStocks.size();

           assertThat(sizeBefore, is(10));

           stocks.createStock(testProduct, CREATE_AMOUNT);



           allStocks = stocks.listAll();
           assertThat(allStocks.size(), is(sizeBefore + 1));




       }
   }


    public static class findByAmountLess extends StockIntegTest{

        @Test
        public void findByAmountTest() {



            List<Stock> stocksByAmount = stocks.findByAmount(1);
            assertNotNull(stocksByAmount);
            assertFalse(stocksByAmount.isEmpty());

            Stock s = stocksByAmount.get(0);

            assertThat(s.getAmount(), is(1));
            assertThat(s.getProduct(), is(testProduct));

        }

    }


    public static class findByAmountLessThan extends StockIntegTest{


        @Test
        public void findByAmountLessThan() {


            List<Stock> stocksLessThan = stocks.findByAmountLessThan(11);

            //10 producten in totaal
            assertThat("Size = " + stocksLessThan.size(), stocksLessThan.size(), is(10));

            //0 stock met amount 1
            stocksLessThan = stocks.findByAmountLessThan(1);
            assertThat(stocksLessThan.size(), is(0));

            //0 stock met minder dan 0
            stocksLessThan = stocks.findByAmountLessThan(0);

            assertTrue(stocksLessThan.isEmpty());


        }
    }

    public static class findByAmountMoreThan extends StockIntegTest {


        @Test
        public void findByAmountMoreThan() {

            List<Stock> stocksMoreThan = stocks.findByAmountMoreThan(0);

            assertThat("SIZE = " + stocks.listAll().size(), stocksMoreThan.size(), is(10));

            // geen stock met meer dan 11
            stocksMoreThan = stocks.findByAmountMoreThan(10);

            assertTrue(stocksMoreThan.isEmpty());

            stocksMoreThan = stocks.findByAmountMoreThan(10);


            //1 met 10
            assertThat(stocksMoreThan.size(), is(0));

        }

    }

    public static class deleteStock  extends StockIntegTest{


        @Test
        public void deleteStockTest() {

            List<Stock> allStocks = stocks.listAll();

            assertFalse(allStocks.isEmpty());
            for (Stock s : allStocks) {

                stocks.removeStock(s);
            }

            allStocks = stocks.listAll();

            assertTrue(allStocks.isEmpty());

            assertFalse(products.listAll().isEmpty());

        }

    }



}
