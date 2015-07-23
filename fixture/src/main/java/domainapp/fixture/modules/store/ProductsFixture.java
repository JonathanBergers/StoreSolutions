package domainapp.fixture.modules.store;

import domainapp.dom.modules.store.stock.Products;
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

    public final List<String> NAMES = Collections.unmodifiableList(Arrays.asList(
            "Appel", "Roos", "Mes", "Kaas", "Lepel", "Ketting", "Armband", "Pot", "Koek", "Hoed"));



    @Override
    protected void execute(ExecutionContext executionContext) {


        for(String s: NAMES){

            BigDecimal costPrice = BigDecimal.valueOf(Math.random()*10);
            BigDecimal sellingPrice = BigDecimal.valueOf((Math.random()*10) + 5);

            products.createProduct(s, sellingPrice, costPrice);
        }


    }


    @Inject
    Products products;
}
