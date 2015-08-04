package domainapp.integtests.tests.modules.stockpilemanagement;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.product.element.*;
import domainapp.fixture.modules.TeardownFixture;
import domainapp.fixture.modules.stockpilemanagement.ProductElementsFixture;
import domainapp.fixture.modules.stockpilemanagement.ProductsFixture;
import domainapp.integtests.tests.SimpleAppIntegTest;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by jonathan on 4-8-15.
 */
public class ProductElementsIntegTest extends SimpleAppIntegTest{


    @Before
    public void setUp(){

        scenarioExecution().install(new TeardownFixture());
        scenarioExecution().install(new ProductsFixture());
        scenarioExecution().install(new ProductElementsFixture());
    }

    @Inject
    ProductElements productElements;





    public static class listAllTest extends ProductElementsIntegTest {

        @Test
        public void listAllTextTest() {

            List<ProductElementText> allTextElements = productElements.listAll(ProductElementText.class);
            assertNotNull(allTextElements);
            assertFalse(allTextElements.isEmpty());

            assertThat(allTextElements.size(), is(10));


        }

        @Test
        public void listAllNumericTest() {

            List<ProductElementNumeric> allNumericElements = productElements.listAll(ProductElementNumeric.class);
            assertNotNull(allNumericElements);
            assertFalse(allNumericElements.isEmpty());

            assertThat(allNumericElements.size(), is(10));


        }

        @Test
        public void listAllElements() {

            List<ProductElement> allElements = productElements.listAll();
            assertNotNull(allElements);
            assertFalse(allElements.isEmpty());

            assertThat(allElements.size(), is(20));


        }

    }



    public static class findByTypeTest extends ProductElementsIntegTest{

        @Test
       public void findTextByType(){

            // 10 van type text
            // good weather
            List<ProductElementText> elementTexts = productElements.findByType(ProductElementText.class, ProductElementsFixture.ELEMENT_TYPE_TEXT);

            assertNotNull(elementTexts);
            assertFalse(elementTexts.isEmpty());

            assertThat(elementTexts.size(), is(10));

            for(ProductElementText p: elementTexts){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

            }

            // bad weather
            elementTexts = productElements.findByType(ProductElementText.class, "Bullcrap");


            assertThat(elementTexts.size(), is(0));




        }


        public void findNumericByType(){

            // 10 van type text
            // good weather
            List<ProductElementNumeric> elementNumeric = productElements.findByType(ProductElementNumeric.class, ProductElementsFixture.ELEMENT_TYPE_NUMERIC);

            assertNotNull(elementNumeric);
            assertFalse(elementNumeric.isEmpty());

            assertThat(elementNumeric.size(), is(10));

            for(ProductElementNumeric p: elementNumeric){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

            // bad weather
            elementNumeric = productElements.findByType(ProductElementNumeric.class, "Bullcrap");


            assertThat(elementNumeric.size(), is(0));





        }

        public void findByType(){

            // 10 van type numeric
            List<ProductElement> elements = productElements.findByType(ProductElementsFixture.ELEMENT_TYPE_NUMERIC);

            assertNotNull(elements);
            assertFalse(elements.isEmpty());

            assertThat(elements.size(), is(10));

            for(ProductElement p: elements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

            // 10 van type text
            elements = productElements.findByType(ProductElementsFixture.ELEMENT_TYPE_TEXT);

            assertNotNull(elements);
            assertFalse(elements.isEmpty());

            assertThat(elements.size(), is(10));

            for(ProductElement p: elements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

            }




            // bad weather
            elements = productElements.findByType("Bullcrap");


            assertThat(elements.size(), is(0));

        }


        public void findByTypeContains(){



            // general

            // 10 van type numeric
            List<ProductElement> elements = productElements.findByTypeContains(ProductElementsFixture.ELEMENT_TYPE_NUMERIC.substring(3));

            assertNotNull(elements);
            assertFalse(elements.isEmpty());

            assertThat(elements.size(), is(10));

            for(ProductElement p: elements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

            // 10 van type text
            elements = productElements.findByTypeContains(ProductElementsFixture.ELEMENT_TYPE_TEXT.substring(3));

            assertNotNull(elements);
            assertFalse(elements.isEmpty());

            assertThat(elements.size(), is(10));

            for(ProductElement p: elements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

            }


            // bad weather
            elements = productElements.findByTypeContains("Bullcrap");


            assertThat(elements.size(), is(0));


            // child classes


            // general

            // numeric child
            List<ProductElementNumeric> numElements = productElements.findByTypeContains(ProductElementNumeric.class, ProductElementsFixture.ELEMENT_TYPE_NUMERIC.substring(3));

            assertNotNull(numElements);
            assertFalse(numElements.isEmpty());

            assertThat(numElements.size(), is(10));

            for(ProductElement p: numElements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

            // bad weather
            numElements = productElements.findByTypeContains(ProductElementNumeric.class, "Bullcrap");

            // text child
            List<ProductElementText> textElements = productElements.findByTypeContains(ProductElementText.class, ProductElementsFixture.ELEMENT_TYPE_TEXT.substring(3));

            assertNotNull(numElements);
            assertFalse(numElements.isEmpty());

            assertThat(numElements.size(), is(10));

            for(ProductElement p: numElements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

            }


            // bad weather
            textElements = productElements.findByTypeContains(ProductElementText.class, "Bullcrap");


            assertThat(numElements.size(), is(0));


        }

        public void findByTypeStartswith(){



            // general

            // 10 van type numeric
            List<ProductElement> elements = productElements.findByTypeStartswith(ProductElementsFixture.ELEMENT_TYPE_NUMERIC.substring(0, 4));

            assertNotNull(elements);
            assertFalse(elements.isEmpty());

            assertThat(elements.size(), is(10));

            for(ProductElement p: elements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

            // 10 van type text
            elements = productElements.findByTypeContains(ProductElementsFixture.ELEMENT_TYPE_TEXT.substring(3));

            assertNotNull(elements);
            assertFalse(elements.isEmpty());

            assertThat(elements.size(), is(10));

            for(ProductElement p: elements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

            }


            // bad weather
            elements = productElements.findByTypeContains("Bullcrap");


            assertThat(elements.size(), is(0));


            // child classes


            // general

            // numeric child
            List<ProductElementNumeric> numElements = productElements.findByTypeStartswith(ProductElementNumeric.class, ProductElementsFixture.ELEMENT_TYPE_NUMERIC.substring(0, 3));

            assertNotNull(numElements);
            assertFalse(numElements.isEmpty());

            assertThat(numElements.size(), is(10));

            for(ProductElement p: numElements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

            // bad weather
            numElements = productElements.findByTypeStartswith(ProductElementNumeric.class, "Bullcrap");

            // text child
            List<ProductElementText> textElements = productElements.findByTypeStartswith(ProductElementText.class, ProductElementsFixture.ELEMENT_TYPE_TEXT.substring(0, 3));

            assertNotNull(numElements);
            assertFalse(numElements.isEmpty());

            assertThat(numElements.size(), is(10));

            for(ProductElement p: numElements){

                assertThat(p.getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

            }


            // bad weather
            textElements = productElements.findByTypeStartswith(ProductElementText.class, "Bullcrap");


            assertThat(numElements.size(), is(0));


        }








    }




    public static class findByProductTest extends ProductElementsIntegTest{


        @Inject
        Products products;


        public void findByProductTest(){


            List<Product> allProducts = products.listAll();

            for(Product p: allProducts){

                List<ProductElement> elements = productElements.findByProduct(p);

                assertNotNull(elements);
                assertFalse(elements.isEmpty());
                assertThat(elements.size(), is(2));

                List<ProductElementText> textElements = productElements.findByProduct(ProductElementText.class, p);

                assertNotNull(textElements);
                assertFalse(textElements.isEmpty());
                assertThat(textElements.size(), is(1));
                assertThat(textElements.get(0).getType(), is(ProductElementsFixture.ELEMENT_TYPE_TEXT));

                List<ProductElementNumeric> numericElements = productElements.findByProduct(ProductElementNumeric.class, p);

                assertNotNull(numericElements);
                assertFalse(numericElements.isEmpty());
                assertThat(numericElements.size(), is(1));
                assertThat(numericElements.get(0).getType(), is(ProductElementsFixture.ELEMENT_TYPE_NUMERIC));

            }

        }


    }


}
