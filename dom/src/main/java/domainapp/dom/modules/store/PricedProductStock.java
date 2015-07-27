package domainapp.dom.modules.store;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

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
public class PricedProductStock {




    @Programmatic
    public BigDecimal calculateTotalSellingPrice() {
        return getProduct().getSellingPrice().multiply(BigDecimal.valueOf(getAmount()));
    }
    //endregion

    //region > calculateTotal (action)
    @Programmatic
    public BigDecimal calculateTotalProfit() {
        return (getProduct().getSellingPrice().min(getProduct().getCostPrice())).multiply(BigDecimal.valueOf(getAmount()));
    }
    //endregion


    //region > calculateTotal (action)
    @Programmatic
    public BigDecimal calculateTotalCostPrice() {
        return getProduct().getCostPrice().multiply(BigDecimal.valueOf(getAmount()));
    }


    //region > amount (property)
    private Integer amount;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }
    //endregion

    //region > product (property)
    private PricedProduct product;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public PricedProduct getProduct() {
        return product;
    }

    public void setProduct(final PricedProduct product) {
        this.product = product;
    }
    //endregion
}
