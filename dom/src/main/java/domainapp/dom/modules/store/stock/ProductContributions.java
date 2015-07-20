package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.value.Blob;

import javax.inject.Inject;

/**
 * Created by jonathan on 14-7-15.
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class ProductContributions {


    //region > addElement (action)
    @MemberOrder(sequence = "1")
    @Action
    public PhotoElement addPhoto(final Product product, final String title, final Blob photo) {

        PhotoElement photoElement = container.newTransientInstance(PhotoElement.class);
        photoElement.setItem(product);
        photoElement.setTitle(title);
        photoElement.setPhoto(photo);
        photoElement.setColenam(title);


        container.persistIfNotAlready(photoElement);
        product.addElement(photoElement);
        return photoElement;

    }
    //endregion


    //region > addStock (action)
    @MemberOrder(sequence = "1")
    public ProductStock addStock(final Product product, final int amount) {

        ProductStock ps = container.newTransientInstance(ProductStock.class);
        ps.setAmount(amount);
        ps.setItem(product);
        container.persist(ps);
        return ps;
    }

    //endregion
    @Inject
    DomainObjectContainer container;


}
