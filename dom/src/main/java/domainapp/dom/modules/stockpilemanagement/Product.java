package domainapp.dom.modules.stockpilemanagement;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import java.math.BigDecimal;
import java.util.List;

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
@Unique(name = "title")
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

    //region > description (property)
    private String description;

    @MemberOrder(sequence = "2")
    @Column(allowsNull = "true")
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    public String getDescription() {
        return description;
    }

    public void setDescription(final String summary) {
        this.description = summary;
    }


    //region > costPrice (property)
    private BigDecimal costPrice;

    @MemberOrder(sequence = "4")
    @Column(allowsNull = "false")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(final BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    //endregion


    //region > sellingPrice (property)
    private BigDecimal sellingPrice;

    @MemberOrder(sequence = "5")
    @Column(allowsNull = "false")
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    //endregion




    @Inject
    DomainObjectContainer container;

    @Inject
    Stocks stocks;


}
