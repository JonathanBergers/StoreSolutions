package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;

import javax.jdo.annotations.*;


/**
 * Created by jonathan on 14-7-15.
 */

//@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Discriminator(
        strategy = DiscriminatorStrategy.CLASS_NAME,
        column = "discriminator")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
public class ItemElement<T extends ItemElement<T, Z>, Z extends Item<Z>>
        extends AbstractDomainObject
        implements Comparable<T> {


    String title(){
        if(title != null && !title.isEmpty()) {
            return title;
        }else{
            return "Unnamed item";
        }
    }

    //region > title (property)
    private String title;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
    //endregion


    //region > item (property)

    private Z item;


    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    @Programmatic
    public  Z getItem() {
        return item;
    }

    public void setItem(final Z item) {
        this.item = item;
    }

    @Override
    public int compareTo(T o) {
        return getTitle().compareTo(o.getTitle());
    }
    //endregion

}
