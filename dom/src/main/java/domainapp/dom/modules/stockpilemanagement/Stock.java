package domainapp.dom.modules.stockpilemanagement;


import domainapp.dom.modules.store.stock.Product;
import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.ObjectContracts;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 13-7-15.
 */

/**de children hiervan slaan de attributen niet op.
 * als deze klasse persistence capable is dan krijg je een error.
 *
 *
 * @param <T>
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
public abstract class Stock<T extends Item<T>, Z extends Stock<T,Z>>
extends AbstractDomainObject implements Comparable<Z>
       {

           // fking bug
//
//           //region > item (property)
//           protected T item;
//
//           @MemberOrder(sequence = "1")
//           public T getItem() {
//               return item;
//           }
//
//           public void setItem(final T item) {
//               this.item = item;
//           }
//           //endregion
//


    //region > amount (property)

    private int amount;

    @MemberOrder(sequence = "3")
    @Column(allowsNull = "false")
    public int getAmount() {
        return amount;
    }



    public void setAmount(final int amount) {
        this.amount = amount;
    }



    //endregion










}
