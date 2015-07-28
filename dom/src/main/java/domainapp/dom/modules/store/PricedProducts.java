package domainapp.dom.modules.store;

import com.google.common.base.Predicates;
import domainapp.dom.util.StorePredicates;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
@DomainService(nature = NatureOfService.DOMAIN)
public class PricedProducts extends Products implements PricedProductsInterface<PricedProduct>{


    //region > createProduct (action)
    @Programmatic
    public PricedProduct createPricedProduct(final String title, final String description, final BigDecimal costPrice, final BigDecimal sellingPrice) {

        PricedProduct p = container.newTransientInstance(PricedProduct.class);
        p.setTitle(title);
        p.setDescription(description);
        p.setCostPrice(costPrice);
        p.setSellingPrice(sellingPrice);


        container.persist(p);
        return p;
    }
    //endregion


    @Programmatic
    public List<PricedProduct> findByCostPrice(final BigDecimal costPrice){

        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithCostPrice(costPrice));
    }

    @Programmatic
    public List<PricedProduct> findBySellingPrice(BigDecimal sellingPrice) {
        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithSellingPrice(sellingPrice));
    }

    @Programmatic
    public List<PricedProduct> findByCostPriceLowerThan(BigDecimal costPrice) {
        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithCostLowerThan(costPrice));
    }

    @Programmatic
    public List<PricedProduct> findByCostPriceHigherThan(BigDecimal costPrice) {
        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithCostHigherThan(costPrice));
    }

    @Programmatic
    public List<PricedProduct> findBySellingPriceLowerThan(BigDecimal sellingPrice) {
        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithSellingPriceLowerThan(sellingPrice));
    }

    @Programmatic
    public List<PricedProduct> findBySellingPriceHigherThan(BigDecimal sellingPrice) {
        return container.allMatches(PricedProduct.class, StorePredicates.PricedProductPredicate.thoseWithSellingPriceHigherThan(sellingPrice));
    }

    @Programmatic
    public List<PricedProduct> findBySellingPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return container.allMatches(PricedProduct.class, Predicates.and(StorePredicates.PricedProductPredicate.thoseWithSellingPriceHigherThan(minPrice),
                StorePredicates.PricedProductPredicate.thoseWithSellingPriceLowerThan(maxPrice)));
    }

    @Inject
    DomainObjectContainer container;


}
