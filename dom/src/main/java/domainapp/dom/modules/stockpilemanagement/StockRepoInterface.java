package domainapp.dom.modules.stockpilemanagement;



import java.util.List;

/**
 * Created by jonathan on 27-7-15.
 */
public interface StockRepoInterface {

    public List<Stock> listAll();

    public List<Stock> findByProduct(final Product product);

    public List<Stock> findByAmount(final Integer amount);

    public List<Stock> findByAmountLessThan(final Integer amount);

    public List<Stock> findByAmountMoreThan(final Integer amount);



}
