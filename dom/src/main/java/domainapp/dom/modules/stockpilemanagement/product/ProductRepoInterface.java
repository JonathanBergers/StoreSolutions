package domainapp.dom.modules.stockpilemanagement.product;

import domainapp.dom.util.SearchTypes;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.ParameterLayout;

import java.util.List;

/**
 * Created by jonathan on 26-7-15.
 */
public interface ProductRepoInterface<T extends Product> {


    @ActionLayout(named = "Alle producten")
    public List<T> listAll();


    public List<T> findByTitleOrDescription(final SearchTypes.Text type,
                                            final String text);


}
