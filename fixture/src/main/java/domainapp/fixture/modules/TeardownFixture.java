package domainapp.fixture.modules;

import domainapp.fixture.DomainAppFixturesService;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.objectstore.jdo.applib.service.support.IsisJdoSupport;

/**
 * Created by jonathan on 27-7-15.
 */
public class TeardownFixture extends FixtureScript {

    @javax.inject.Inject
    private IsisJdoSupport isisJdoSupport;
    @Override
    protected void execute(ExecutionContext executionContext) {
        isisJdoSupport.executeUpdate("delete from \"Stock\"");

        isisJdoSupport.executeUpdate("delete from \"Product\"");
    }
}
