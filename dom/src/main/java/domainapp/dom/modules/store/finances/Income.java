package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.ProductStock;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;
import java.math.BigDecimal;

/**
 * Created by jonathan on 14-7-15.
 * store krijgt income door producten verkopen
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class Income extends Finance {

        //region > storeObject (property)
        private ProductStock stock;

        @MemberOrder(sequence = "1")
        @Column(allowsNull = "false")
        public ProductStock getStock() {
                return stock;
        }

        public void setStock(final ProductStock stock) {
                this.stock = stock;
        }
        //endregion


        @Override
        public BigDecimal getValue() {
                return getStock().calculateTotalSellingPrice();
        }


}
