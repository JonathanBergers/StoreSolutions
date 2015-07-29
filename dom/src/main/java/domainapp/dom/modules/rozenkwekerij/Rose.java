package domainapp.dom.modules.rozenkwekerij;

import domainapp.dom.modules.store.PricedProduct;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 28-7-15.
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class Rose extends PricedProduct {


    //region > strain (property)
    private RoseStrain strain;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public RoseStrain getStrain() {
        return strain;
    }

    public void setStrain(final RoseStrain strain) {
        this.strain = strain;
    }
//endregion





}
