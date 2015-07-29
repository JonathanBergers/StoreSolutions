package domainapp.fixture.modules;

import domainapp.fixture.modules.stockpilemanagement.PricedProductsFixture;
import domainapp.fixture.modules.stockpilemanagement.ProductElementsFixture;
import domainapp.fixture.modules.stockpilemanagement.ProductsFixture;
import domainapp.fixture.modules.stockpilemanagement.StockFixture;
import org.apache.isis.applib.fixturescripts.FixtureScript;

/**
 * Created by jonathan on 23-7-15.
 */
public class StoreFixtureScript extends FixtureScript {

    public StoreFixtureScript() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(ExecutionContext executionContext) {

        //executionContext.executeChild(this, new ProductsFixture());
        executionContext.executeChild(this, new PricedProductsFixture());
        executionContext.executeChild(this, new StockFixture());
        executionContext.executeChild(this, new ProductElementsFixture());


    }
}
