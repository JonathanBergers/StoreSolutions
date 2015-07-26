package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.annotation.MemberOrder;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.Column;

/**
 * Created by jonathan on 25-7-15.
 */
public interface ProductWithDate {



    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public LocalDateTime getTimeStamp();

    public void setTimeStamp(final LocalDateTime timeStamp);
    //endregion
}
