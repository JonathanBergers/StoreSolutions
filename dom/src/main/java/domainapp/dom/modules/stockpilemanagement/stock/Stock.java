package domainapp.dom.modules.stockpilemanagement.stock;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.PropertyLayout;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 25-7-15.
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
@DomainObject(editing = Editing.DISABLED)
public class Stock {


    public String title(){
        return "Voorraad: " + getProduct().title() + " " + amount;
    }

    //region > amount (property)
    private Integer amount;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    @PropertyLayout(named = "Hoeveelheid")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
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
