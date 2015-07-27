package domainapp.fixture.modules.stockpilemanagement;

import domainapp.dom.modules.stockpilemanagement.Products;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 20-7-15.
 */
public class ProductsFixture extends FixtureScript{

    public final List<String> NAMES = Collections.unmodifiableList(Arrays.asList(
            "Appel", "Roos", "Mes", "Kaas", "Lepel", "Ketting", "Armband", "Pot", "Koek", "Hoed"));



    @Override
    protected void execute(ExecutionContext executionContext) {


        for(String s: NAMES){


           products.createProduct(s, "dit is een mooie " + s );
        }


    }


    @Inject
    Products products;
}
