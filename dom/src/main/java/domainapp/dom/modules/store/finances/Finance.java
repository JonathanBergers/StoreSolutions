package domainapp.dom.modules.store.finances;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

/**
 * Created by jonathan on 14-7-15.
 * klasse voor financiele dingen zoals uitgaven inkomsten
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
@DomainObject
public abstract class Finance implements Comparable<Finance> {


    //region > timeStamp (property)
    private LocalDate timeStamp;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(final LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
    //endregion


    //region > value (property)
    private BigDecimal value;

    @MemberOrder(sequence = "1")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
    //endregion

    @Override
    public int compareTo(Finance o) {
        return getValue().compareTo(o.getValue());
    }




}
