package domainapp.dom.modules.store.stock;

import domainapp.dom.modules.stockpilemanagement.Item;
import domainapp.dom.modules.stockpilemanagement.Stock;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

/**
 * Created by jonathan on 14-7-15.
 *
 * ERROR, moet alles van de superclass overidden omdat de attributen anders niet opgeslagen worden.
 *
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.NATIVE,
        column = "id")
@DomainObject
public class ProductStock extends Stock<ProductStock, Product> {


    /**Overriden voor datanucleus, kan generieke type blijkbaar niet ge
     *
     */
//    //region > item (property)
//
//
//    @MemberOrder(sequence = "1")
//    @Column(allowsNull = "false")
//    public Product getItem() {
//        return item;
//    }
//
//    @Override
//    public void setItem(final Product item) {
//        this.item = item;
//    }
//    //endregion
//
//
//    //region > amount (property)
//    private int amount;
//
//    @MemberOrder(sequence = "1")
//    @Column(allowsNull = "false")
//    public int getAmount() {
//        return amount;
//    }
//
//
//    public void setAmount(final int amount) {
//        this.amount = amount;
//    }
//    //endregion



    @Override
    public int compareTo(ProductStock o) {
        return getItem().getSellingPrice().compareTo(o.getItem().getSellingPrice());
    }



    //region > calculateTotalSellingPrice (action)
    @Programmatic
    public BigDecimal calculateTotalSellingPrice() {
        return getItem().getSellingPrice().multiply(BigDecimal.valueOf(getAmount()));
    }
    //endregion

    //region > calculateTotal (action)
    @Programmatic
    public BigDecimal calculateTotalProfit() {
        return (getItem().getSellingPrice().min(getItem().getCostPrice())).multiply(BigDecimal.valueOf(getAmount()));
    }
    //endregion


    //region > calculateTotal (action)
    @Programmatic
    public BigDecimal calculateTotalCostPrice() {
        return getItem().getCostPrice().multiply(BigDecimal.valueOf(getAmount()));
    }





    //endregion




}
