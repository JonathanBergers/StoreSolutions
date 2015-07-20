package domainapp.dom.modules.store.stock;

import domainapp.dom.modules.stockpilemanagement.ItemElement;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.value.Blob;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 14-7-15.
 */

@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class PhotoElement  extends ItemElement<PhotoElement, Product> {


    //region > photo (property)
    private Blob photo;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(final Blob photo) {
        this.photo = photo;
    }
    //endregion




    //region > coolenaam (property)
    private String coolenaam;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public String getColenam() {
        return coolenaam;
    }

    public void setColenam(final String coolenaam) {
        this.coolenaam = coolenaam;
    }




    //endregion
}
