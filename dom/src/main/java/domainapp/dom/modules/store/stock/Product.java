package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import java.math.BigDecimal;

/**
 * Created by jonathan on 14-7-15.
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
public class Product{



    //region > title (property)
    private String title;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
    //endregion




    //region > sellingPrice (property)
    private BigDecimal sellingPrice;



    @MemberOrder(sequence = "2")
    @Column(allowsNull = "false")
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    //endregion





    //region > costPrice (property)
    private BigDecimal costPrice;

    @MemberOrder(sequence = "2")
    @Column(allowsNull = "false")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(final BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    //endregion


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

    @Programmatic
    public void addAmount(final Integer amount){
        this.amount += amount;
    }
    //endregion








    //region > calculateTotalSellingPrice (action)
    @Programmatic
    public BigDecimal calculateTotalSellingPrice() {
        return getSellingPrice().multiply(BigDecimal.valueOf(getAmount()));
    }
    //endregion

    //region > calculateTotal (action)
    @Programmatic
    public BigDecimal calculateTotalProfit() {
        return (getSellingPrice().min(getCostPrice())).multiply(BigDecimal.valueOf(getAmount()));
    }
    //endregion


    //region > calculateTotal (action)
    @Programmatic
    public BigDecimal calculateTotalCostPrice() {
        return getCostPrice().multiply(BigDecimal.valueOf(getAmount()));
    }



    @Inject
    DomainObjectContainer container;


}
