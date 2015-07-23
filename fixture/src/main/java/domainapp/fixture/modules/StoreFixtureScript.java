package domainapp.fixture.modules;

import domainapp.fixture.modules.store.ProductStockFixture;
import domainapp.fixture.modules.store.ProductsFixture;
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

        executionContext.executeChild(this, new ProductsFixture());
        executionContext.executeChild(this, new ProductStockFixture());


    }
}
