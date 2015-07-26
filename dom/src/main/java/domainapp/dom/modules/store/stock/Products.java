package domainapp.dom.modules.store.stock;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.joda.time.LocalDateTime;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 14-7-15.
 */

@DomainService(repositoryFor = Product.class)
public class Products {


    //TODO programmatic maken

    //region > createProduct (action)
    @MemberOrder(sequence = "1")
    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public Product createProduct(final String title, final BigDecimal sellingPrice, final BigDecimal costPrice, final Integer amount) {

        Product p = container.newTransientInstance(Product.class);
        p.setTitle(title);
        p.setSellingPrice(sellingPrice);
        p.setCostPrice(costPrice);
        p.setAmount(amount);

        container.persist(p);
        return p;

    }
    //endregion

    @MemberOrder(sequence = "1")
    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    public ProductSold sellProduct(Product product, final LocalDateTime timeStamp, final Integer amount){

        ProductSold p = container.newTransientInstance(ProductSold.class);
        p.setAmount(amount);
        p.setCostPrice(product.getCostPrice());
        p.setTitle(product.getTitle());
        p.setSellingPrice(product.getSellingPrice());
        p.setTimeStamp(timeStamp);

        //vooraad wijzigen
        //TODO gebeurd niet
        product.addAmount(-amount);


        container.persist(p);
        return p;


    }

    @MemberOrder(sequence = "1")
    @Action
    public ProductBought buyProduct(Product product, final LocalDateTime timeStamp, final Integer amount){

        ProductBought p = container.newTransientInstance(ProductBought.class);
        p.setAmount(amount);
        p.setCostPrice(product.getCostPrice());
        p.setTitle(product.getTitle());
        p.setSellingPrice(product.getSellingPrice());
        p.setTimeStamp(timeStamp);

        //vooraad wijzigen
        //TODO gebeurd niet..
        product.addAmount(amount);


        container.persist(p);
        return p;


    }


    //region > listAll (action)
    @MemberOrder(sequence = "1")
    @Action
    public List<Product> listAll() {

        return container.allInstances(Product.class);
    }
    //endregion





    @Action
    public List<Product> findByTitle(String title){

        return container.allMatches(Product.class, ProductPredicates.thoseWithTitleBegins(title));

    }






    @Inject
    DomainObjectContainer container;

}
