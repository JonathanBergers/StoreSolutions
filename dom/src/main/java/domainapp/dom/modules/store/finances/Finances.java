package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.ProductStock;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Programmatic;
import org.joda.time.LocalDate;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 24-7-15.
 */
@DomainService
public class Finances {


    @Programmatic
    public List<Income> listAllIncome(){

        return container.allInstances(Income.class);
    }

    @Programmatic
    public List<Expense> listAllExpense(){

        return container.allInstances(Expense.class);
    }

    @Action
    public Income createIncome(final ProductStock productStock, final LocalDate timeStamp){

        Income income = container.newTransientInstance(Income.class);
        income.setStock(productStock);
        income.setTimeStamp(timeStamp);
        income.setValue(productStock.calculateTotalSellingPrice());

        container.persistIfNotAlready(income);
        return income;


    }

    @Action
    public Expense createExpense(final ProductStock productStock, final LocalDate timeStamp){

        Expense expense = container.newTransientInstance(Expense.class);
        expense.setStock(productStock);
        expense.setTimeStamp(timeStamp);
        expense.setValue(productStock.calculateTotalCostPrice());

        container.persistIfNotAlready(expense);
        return expense;


    }


    @Action
    public FinanceViewModel finances(){

        return new FinanceViewModel();
    }






    @Inject
    DomainObjectContainer container;

}
