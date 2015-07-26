package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.ProductBought;
import domainapp.dom.modules.store.stock.ProductSold;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

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
public class TransactionExpense implements Transaction<ProductBought>{


        //region > products (property)
        private List<ProductBought> products;

        @MemberOrder(sequence = "1")
        @Column(allowsNull = "false")
        public List<ProductBought> getProducts() {
                return products;
        }

        public void setProducts(final List<ProductBought> products) {
                this.products = products;
        }


        //region > timeStamp (property)
        private LocalDate timeStamp;

        @MemberOrder(sequence = "1")
        @Column(allowsNull = "false")
        public LocalDate getTimeStamp() {
                return timeStamp;
        }

        public void setTimeStamp(final LocalDate timeStamp) {
                this.timeStamp = timeStamp;
        }
        //endregion

        //endregion

}