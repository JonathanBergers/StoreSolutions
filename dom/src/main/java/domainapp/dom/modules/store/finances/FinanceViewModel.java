package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.Product;
import domainapp.dom.modules.store.stock.ProductSold;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.NotPersistent;
import java.util.List;
import java.util.SortedSet;

/**
 * Created by jonathan on 25-7-15.
 */
@ViewModel
public class FinanceViewModel {




    @MemberOrder(sequence = "1", name = "expenses")
    @Collection(notPersisted = true)
    @CollectionLayout(render = RenderType.EAGERLY)
    public List<TransactionExpense> getExpenses() {
        return transactions.listExpenses();
    }

    @MemberOrder(sequence = "1")
    @Collection(notPersisted = true)
    @CollectionLayout(render = RenderType.EAGERLY)
    public List<TransactionIncome> getIncome() {
        return transactions.listIncome();
    }


    @MemberOrder(sequence = "2" , name = "expenses")
    public TransactionViewModel createIncome(){

        return new TransactionViewModel();

    }




    @Inject
    Transactions transactions;


}
