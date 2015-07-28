package domainapp.dom.modules.stockpilemanagement.product;

import java.util.List;

/**
 * Created by jonathan on 28-7-15.
 */
public interface ProductsInterface<T extends Product> {


    public List<T> listAll();

    public List<T> findByTitle(final String title);

    public List<T> findByDescriptionContains(final String text);


}
