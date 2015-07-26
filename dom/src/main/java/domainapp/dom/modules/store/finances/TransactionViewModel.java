package domainapp.dom.modules.store.finances;

import com.google.common.collect.Lists;
import domainapp.dom.modules.store.stock.*;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.ViewModel;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jonathan on 25-7-15.
 */
@ViewModel
public class TransactionViewModel {


    //region > products (property)
    private List<TransactionProduct> products;

    @MemberOrder(sequence = "1")
    public List<TransactionProduct> getProducts() {
        return products;
    }

    public void setProducts(final List<TransactionProduct> products) {
        this.products = products;
    }
    //endregion


    //region > addProduct (action)
    @MemberOrder(sequence = "1")
    @Action
    public TransactionViewModel addProduct(final Product product, final int amount) {

        TransactionProduct p = container.newTransientInstance(TransactionProduct.class);
        p.setProduct(product);
        p.setAmount(amount);

        products.add(p);

        return this;
    }


    public List<Product> autoComplete0AddProduct(final String search) {
        return productsInject.findByTitle(search);
    }


    //endregion


    //region > createTransactionIncome (action)
    @MemberOrder(sequence = "1")
    public TransactionIncome createTransactionIncome() {

        List<ProductSold> ps = new ArrayList<>();
        for(TransactionProduct tp: products){

           ps.add(productsInject.sellProduct(tp.getProduct(), new LocalDateTime(), tp.getAmount()));
        }

        TransactionIncome ts = container.newTransientInstance(TransactionIncome.class);
        ts.setProducts(ps);
        ts.setTimeStamp(new LocalDate());

        return ts;




    }
    //endregion


    @Inject
    Products productsInject;

    @Inject
    DomainObjectContainer container;

}
