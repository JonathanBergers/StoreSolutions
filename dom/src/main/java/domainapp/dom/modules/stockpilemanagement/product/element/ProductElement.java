package domainapp.dom.modules.stockpilemanagement.product.element;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 28-7-15.
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
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
@Unique(name = "type")
@DomainObject(editing = Editing.DISABLED)
public abstract class ProductElement {


    //region > type (property)
    private String type;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }
    //endregion




    //region > displayValue (property)
    private String displayValue;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(final String displayValue) {
        this.displayValue = displayValue;
    }
    //endregion

    //region > product (property)
    private Product product;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }
    //endregion


}
