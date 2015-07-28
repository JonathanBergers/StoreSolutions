package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

/**
 * Created by jonathan on 26-7-15.
 */

@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class PricedProduct extends Product {


    //region > sellingPrice (property)
    private BigDecimal sellingPrice;



    @MemberOrder(sequence = "4")
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

    @MemberOrder(sequence = "5")
    @Column(allowsNull = "false")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(final BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    //endregion


}
