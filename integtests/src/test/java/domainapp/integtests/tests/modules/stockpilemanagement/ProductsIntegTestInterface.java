package domainapp.integtests.tests.modules.stockpilemanagement;

import domainapp.fixture.modules.StoreFixtureScript;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jonathan on 27-7-15.
 */
public interface ProductsIntegTestInterface {



    @Test
    public void createProductTest();

    @Test
    public void findByTitleTest();

    @Test
    public void findByDescriptionContainsTest();





}
