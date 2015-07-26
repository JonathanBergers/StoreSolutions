package domainapp.dom.modules.store.finances;

import domainapp.dom.modules.store.stock.Product;
import domainapp.dom.modules.store.stock.ProductBought;
import domainapp.dom.modules.store.stock.ProductWithDate;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Programmatic;
import org.joda.time.LocalDate;

import javax.jdo.annotations.Column;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jonathan on 25-7-15.
 */
public interface Transaction<T extends ProductWithDate> {



    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public List<T> getProducts();

    public void setProducts(final List<T> products);

    //region > timeStamp (property)
    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public LocalDate getTimeStamp();

    public void setTimeStamp(final LocalDate timeStamp);

    //endregion

}
