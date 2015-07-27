package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.ProductRepoInterface;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jonathan on 26-7-15.
 */
public interface PricedItemRepo<T extends PricedProduct> extends ProductRepoInterface<PricedProduct> {


    public List<T> findByPrice();

    public List<T> findByPriceLowerThan(BigDecimal price);

    public List<T> findByPriceHigherThan(BigDecimal price);





}
