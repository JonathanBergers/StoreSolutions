package domainapp.dom.modules.stockpilemanagement.product.element;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.PropertyLayout;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 28-7-15.
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class ProductElementText extends ProductElement {


    //region > value (property)
    private String value;

    @Column(allowsNull = "false")
    @PropertyLayout(named = "Textuele waarde")
    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
    //endregion

}
