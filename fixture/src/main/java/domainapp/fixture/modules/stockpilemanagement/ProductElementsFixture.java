package domainapp.fixture.modules.stockpilemanagement;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElementEntity;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
public class ProductElementsFixture extends FixtureScript {



    public static final String ELEMENT_TYPE_TEXT = "Kleur";
    public static final String ELEMENT_TYPE_NUMERIC = "Gewicht";
    public static final List<String> COLORS = Collections.unmodifiableList(Arrays.asList(
            "Groen", "Rood", "Zilver", "Geel", "Goud", "Bruin", "Blauw", "Grijs", "Zwart", "Roze"));





    @Override
    protected void execute(ExecutionContext executionContext) {

        List<Product> productList = products.listAll();

        for (int i = 0; i <productList.size(); i++) {
            Product p = productList.get(i);
            productElements.createProductElementText(p, ELEMENT_TYPE_TEXT, COLORS.get(i));
            productElements.createProductElementNumeric(p, ELEMENT_TYPE_NUMERIC, ProductElementEntity.GR, i * 100);

        }

    }



    @Inject
    Products products;

    @Inject
    ProductElements productElements;
}
