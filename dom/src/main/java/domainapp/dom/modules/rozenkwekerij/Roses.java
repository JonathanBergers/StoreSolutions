package domainapp.dom.modules.rozenkwekerij;

import domainapp.dom.modules.store.PricedProduct;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by jonathan on 30-7-15.
 */
@DomainService(nature = NatureOfService.DOMAIN)
public class Roses {




    //region > createProduct (action)
    @Programmatic
    public Rose createRose(final String title, final String description, final BigDecimal costPrice, final BigDecimal sellingPrice, final RoseStrain strain) {

        Rose p = container.newTransientInstance(Rose.class);
        p.setTitle(title);
        p.setDescription(description);
        p.setCostPrice(costPrice);
        p.setSellingPrice(sellingPrice);
        p.setStrain(strain);


        container.persist(p);
        return p;
    }
    //endregion

    @Inject
    DomainObjectContainer container;
}


