package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.ProductRepoInterface;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 26-7-15.
 */
public interface PricedProductsInterface<T extends PricedProduct> extends ProductRepoInterface<PricedProduct> {

    public List<T> findByCostPrice(final BigDecimal costPrice);

    public List<T> findBySellingPrice(final BigDecimal sellingPrice);


    public List<T> findByCostPriceLowerThan(final BigDecimal costPrice);

    public List<T> findByCostPriceHigherThan(final BigDecimal costPrice);



    public List<T> findBySellingPriceLowerThan(final BigDecimal sellingPrice);

    public List<T> findBySellingPriceHigherThan(final BigDecimal sellingPrice);


    public List<T> findBySellingPriceBetween(final BigDecimal minPrice, final BigDecimal maxPrice);


}
