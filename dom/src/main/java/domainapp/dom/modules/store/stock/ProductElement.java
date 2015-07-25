package domainapp.dom.modules.store.stock;

import domainapp.dom.modules.stockpilemanagement.ItemElement;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 14-7-15.
 */

@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public  class ProductElement<T> extends ItemElement<ProductElement<T>, Product> {


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


//    //region > value (property)
//    private T value;
//
//    @MemberOrder(sequence = "1")
//    @Column(allowsNull = "false")
//    public T getValue() {
//        return value;
//    }
//
//    public void setValue(final T value) {
//        this.value = value;
//    }
//    //endregion




    //endregion
}
