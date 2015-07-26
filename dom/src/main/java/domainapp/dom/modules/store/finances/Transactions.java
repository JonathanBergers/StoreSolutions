package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.*;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;
import org.joda.time.LocalDate;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jdo.Transaction;
import java.util.List;

/**
 * Created by jonathan on 25-7-15.
 */
@DomainService
public class Transactions<T extends ProductWithDate> {


    @Programmatic
    public List<TransactionIncome> listIncome(){

        return container.allInstances(TransactionIncome.class);
    }

    @Programmatic
    public List<TransactionExpense> listExpenses(){

        return container.allInstances(TransactionExpense.class);
    }

    @Action
    public FinanceViewModel finances(){
        return new FinanceViewModel();
    }


    //region > createTransactionIncome (action)
    @MemberOrder(sequence = "1")
    @Programmatic
    public TransactionIncome createTransactionIncome(final List<ProductSold> products) {

        TransactionIncome t = container.newTransientInstance(TransactionIncome.class);
        t.setProducts(products);
        t.setTimeStamp(new LocalDate());
        container.persist(t);

        return t;
    }
    //endregion


    //region > createTransactionIncome (action)
    @MemberOrder(sequence = "1")
    @Programmatic
    public TransactionExpense createTransactionExpense(final List<ProductBought> products) {

        TransactionExpense t = container.newTransientInstance(TransactionExpense.class);
        t.setProducts(products);
        t.setTimeStamp(new LocalDate());
        container.persist(t);

        return t;
    }
    //endregion



    @Inject
    DomainObjectContainer container;


    @Inject
    Products productsInject;
}
