package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 26-7-15.
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


    //region > amount (property)
    private Integer amount;

    @MemberOrder(sequence = "1")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }
    //endregion

//    //region > product (property)
//    private T product;
//
//    @MemberOrder(sequence = "1")
//    public T getProduct() {
//        return product;
//    }
//
//    public void setProduct(final T product) {
//        this.product = product;
//    }
//    //endregion

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
