package domainapp.integtests.tests.modules.stockpilemanagement;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jonathan on 27-7-15.
 */
public interface StocksIntegTestInterface {


    @Test
    public void createStockTest();
    @Test
    public void findByAmountTest();
    @Test
    public void findByAmountLessThan();
    @Test
    public void findByAmountMoreThan();

    @Test
    public void deleteStockTest();






}
