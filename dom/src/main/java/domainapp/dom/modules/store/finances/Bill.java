package domainapp.dom.modules.store.finances;

import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RenderType;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.*;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jonathan on 14-7-15.
 */

@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.NATIVE,
        column = "id")
@Discriminator(
        strategy = DiscriminatorStrategy.CLASS_NAME,
        column = "discriminator")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
public abstract class Bill {


    //region > timeStamp (property)
    private LocalDateTime timeStamp;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(final LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    //endregion


    //region > finances (property)
    private SortedSet<Finance> finances = new TreeSet<>();

    @CollectionLayout(render= RenderType.EAGERLY)
    @Persistent(dependentElement = "true")
    public SortedSet<Finance> getFinances() {
        return finances;
    }

    public void setFinances(final SortedSet<Finance> finances) {
        this.finances = finances;
    }
    //endregion










}
