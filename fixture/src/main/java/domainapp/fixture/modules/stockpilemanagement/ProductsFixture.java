package domainapp.fixture.modules.stockpilemanagement;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 20-7-15.
 */
public class ProductsFixture extends FixtureScript{

    public static final List<String> TITLES = Collections.unmodifiableList(Arrays.asList(
            "Appel", "Roos", "Mes", "Kaas", "Lepel", "Ketting", "Armband", "Pot", "Koek", "Hoed"));


    public static final String PRODUCT_DESCRIPTION = "Dit is een mooie ";

    @Override
    protected void execute(ExecutionContext executionContext) {


        assert products.listAll().isEmpty();

        for(String s: TITLES){


            BigDecimal costPrice = BigDecimal.valueOf(5);
            BigDecimal sellingPrice = BigDecimal.valueOf(10);

            Product p = products.createProduct(s, PRODUCT_DESCRIPTION + s);
          executionContext.addResult(this, p);
        }


    }


    @Inject
    Products products;
}
