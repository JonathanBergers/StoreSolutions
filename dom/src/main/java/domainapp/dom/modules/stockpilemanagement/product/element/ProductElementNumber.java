package domainapp.dom.modules.stockpilemanagement.product.element;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 28-7-15.
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class ProductElementNumber extends ProductElement {





    //region > value (property)
    private int value;

    @Column(allowsNull = "false")
    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }
    //endregion

    //region > entity (property)
    private ProductElementEntity entity;


    @Column(allowsNull = "false")
    public ProductElementEntity getEntity() {
        return entity;
    }

    public void setEntity(final ProductElementEntity entity) {
        this.entity = entity;
    }


    //endregion

}
