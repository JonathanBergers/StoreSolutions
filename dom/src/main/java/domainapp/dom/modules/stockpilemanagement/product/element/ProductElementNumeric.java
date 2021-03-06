package domainapp.dom.modules.stockpilemanagement.product.element;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.util.ObjectContracts;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 28-7-15.
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class ProductElementNumeric extends ProductElement<ProductElementNumeric> {





    //region > value (property)
    private int value;

    @Column(allowsNull = "false")
    @PropertyLayout(named = "Nummerieke waarde")
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
    @PropertyLayout(named = "Eenheid")
    public ProductElementEntity getEntity() {
        return entity;
    }

    public void setEntity(final ProductElementEntity entity) {
        this.entity = entity;
    }

    @Override
    public int compareTo(ProductElementNumeric o) {

        if(getValue() > o.getValue()){
            return 1;
        }else if(getValue() < o.getValue()){
            return -1;
        }

        return 0;

    }


    //endregion

}
