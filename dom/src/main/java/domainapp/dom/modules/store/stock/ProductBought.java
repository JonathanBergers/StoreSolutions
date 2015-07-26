package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 25-7-15.
 */

@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class ProductBought extends Product implements ProductWithDate{

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

}
