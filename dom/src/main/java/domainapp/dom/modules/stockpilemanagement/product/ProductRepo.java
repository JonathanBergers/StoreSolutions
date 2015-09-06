package domainapp.dom.modules.stockpilemanagement.product;

import domainapp.dom.util.SearchTypes;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */

public class ProductRepo implements ProductRepoInterface<Product>{




    @ActionLayout(named = "Alle producten")
    @MemberOrder(sequence = "1")
    public List<Product> listAll() {
        return products.listAll();
    }

    @ActionLayout(named = "Titel of beschrijving")
    @MemberOrder(sequence = "2")
    public List<Product> findByTitleOrDescription(@ParameterLayout(named = "Zoek in ")final SearchTypes.Text type, @ParameterLayout(named = "Text")final String text) {

        switch (type){
            case TITEL: return products.findByTitleContains(text);
            case BESCHRIJVING: return products.findByDescriptionContains(text);
        }
        return products.listAll();


    }






    @Inject
    DomainObjectContainer container;

    @Inject
    Products products;
}
