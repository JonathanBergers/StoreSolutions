package domainapp.dom.modules.store.stock;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
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
public class ProductStock extends Stock<Product, ProductStock> {


    /**Overriden voor datanucleus, kan generieke type blijkbaar niet ge
     *
     */
    //region > item (property)

    private Product item;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public Product getItem() {
        return item;
    }


    public void setItem(final Product item) {
        this.item = item;
    }
    //endregion



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


    public static class Predicates {



        public static Predicate<ProductStock> thoseWithProduct(final Product product) {
            return new Predicate<ProductStock>() {
                @Override
                public boolean apply(final ProductStock ps) {
                    return Objects.equal(ps.getItem(), product);
                }
            };
        }

        public static Predicate<ProductStock> thoseWithAmount(final int amount) {
            return new Predicate<ProductStock>() {
                @Override
                public boolean apply(final ProductStock ps) {
                    return Objects.equal(ps.getAmount(), amount);
                }
            };
        }

        public static Predicate<ProductStock> thoseWithAmountMoreThan(final int amount) {
            return new Predicate<ProductStock>() {
                @Override
                public boolean apply(final ProductStock ps) {
                    return Objects.equal(ps.getAmount() >= amount, true);
                }
            };
        }

        public static Predicate<ProductStock> thoseWithAmountLessThan(final int amount) {
            return new Predicate<ProductStock>() {
                @Override
                public boolean apply(final ProductStock ps) {
                    return Objects.equal(ps.getAmount() <= amount, true);
                }
            };
        }


    }




}
