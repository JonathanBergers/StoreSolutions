package domainapp.dom.modules.store.stock;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import domainapp.dom.modules.stockpilemanagement.*;
import org.apache.isis.applib.annotation.*;

import javax.jdo.annotations.*;
import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jonathan on 14-7-15.
 */


@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.NATIVE,
        column = "id")
@DomainObject
public class Product extends Item<Product> {

//
//    /**
//     * Bug classcast ex
//     */
//    //region > elements (property)
//    private SortedSet<ProductElement> elements = new TreeSet<>();
//
//    @CollectionLayout(render= RenderType.EAGERLY)
//    @Persistent(mappedBy = "item", dependentElement = "true")
//    public SortedSet<ProductElement> getElements() {
//        return elements;
//    }
//
//    public void setElements(final SortedSet<ProductElement> elements) {
//        this.elements = elements;
//    }
//
//    @Programmatic
//    public void addElement(final ProductElement element){
//        elements.add(element);
//    }
//    //endregion




    //region > sellingPrice (property)
    private BigDecimal sellingPrice;

    public Product() {
        super("sellingPrice");
    }

    @MemberOrder(sequence = "2")
    @Column(allowsNull = "false")
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    //endregion





    //region > costPrice (property)
    private BigDecimal costPrice;

    @MemberOrder(sequence = "2")
    @Column(allowsNull = "false")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(final BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    //endregion




    //region > stock (property)
    private SortedSet<ProductStock> stock = new TreeSet<>();

    @CollectionLayout(render= RenderType.EAGERLY)
    @Action(semantics = SemanticsOf.SAFE)
    @Persistent(mappedBy = "item", dependentElement = "true")
    public SortedSet<ProductStock> getStock() {
        return stock;
    }

    public void setStock(final SortedSet<ProductStock> stock) {
        this.stock = stock;
    }

    @Programmatic
    public void addStock(ProductStock productStock){
        stock.add(productStock);
    }
    //endregion


    //region > available (property)
    /**
     * hoeveelheid beschikbare producten, nu nog gewoon het totaal van de stocks.
     *
     */




    @MemberOrder(sequence = "1")
    @Column(allowsNull = "true")
    @NotPersistent
    public Integer getAvailable() {

        return calculateAvailable();

    }


    @Programmatic
    public Integer calculateAvailable(){
        int amount = 0;
        for(Stock s: getStock()){
            amount += s.getAmount();
        }
        return amount;
    }
    //endregion

    public static class Predicates {

        public static Predicate<Product> thoseWithTitle(final String title) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return Objects.equal(product.getTitle().toLowerCase(), title.toLowerCase());
                }
            };
        }


        public static Predicate<Product> thoseWithTitleBegins(final String title) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return Objects.equal(product.getTitle().toLowerCase().startsWith(title.toLowerCase()), true);
                }
            };
        }









    }

}
