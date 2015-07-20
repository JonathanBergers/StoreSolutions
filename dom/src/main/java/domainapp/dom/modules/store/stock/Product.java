package domainapp.dom.modules.store.stock;

import domainapp.dom.modules.stockpilemanagement.Item;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

/**
 * Created by jonathan on 14-7-15.
 */


@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.NATIVE,
        column = "id")
@DomainObject
public class Product extends Item<Product> {






    //region > sellingPrice (property)
    private BigDecimal sellingPrice;

    public Product() {
        super("sellingPrice");
    }

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



}
