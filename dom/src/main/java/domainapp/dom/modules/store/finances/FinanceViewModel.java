package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.ProductStock;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.joda.time.LocalDate;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jonathan on 23-7-15.
 */
@DomainObject(nature = Nature.VIEW_MODEL)
public class FinanceViewModel {



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    @CollectionLayout(render = RenderType.EAGERLY)
    public List<Income> collectIncome(){
        return finances.listAllIncome();

    }


    @Action
    public Income addIncome(final ProductStock productStock){


       return finances.createIncome(productStock, new LocalDate());


    }

    public List<ProductStock> choices0AddIncome() {
        return container.allInstances(ProductStock.class);
    }

    //region > niks (property)
    private Integer niks;

    @MemberOrder(sequence = "1")
    public Integer getNiks() {
        return niks;
    }

    public void setNiks(final Integer niks) {
        this.niks = niks;
    }
    //endregion






    @Inject
    DomainObjectContainer container;

    @Inject
    Finances finances;




}
