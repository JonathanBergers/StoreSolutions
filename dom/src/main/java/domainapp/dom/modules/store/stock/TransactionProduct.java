package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NotPersistable;
import org.apache.isis.applib.annotation.ViewModel;

/**
 * Created by jonathan on 25-7-15.
 */
@ViewModel
public class TransactionProduct {

    //region > product (property)
    private Product product;

    @MemberOrder(sequence = "1")
    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }
    //endregion

    //region > amount (property)
    private int amount;

    @MemberOrder(sequence = "1")
    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }
    //endregion
}
