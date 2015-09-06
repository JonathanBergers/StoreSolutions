package domainapp.dom.modules.stockpilemanagement.product;

import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import java.util.List;

/**
 * Created by jonathan on 14-7-15.
 */



@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Discriminator(
        strategy = DiscriminatorStrategy.CLASS_NAME,
        column = "discriminator")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
@Unique(name = "title")
@DomainObject(editing = Editing.DISABLED)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_CHILD)
@MemberGroupLayout(columnSpans = {4, 0, 0, 8},
        left = {"Foto", "General"})
public class Product{


    public String title(){
        return title;
    }


    //region > title (property)
    private String title;

    @MemberOrder(sequence = "2")
    @Column(allowsNull = "false")
    @PropertyLayout(named = "Titel")
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
    //endregion

    //region > description (property)
    private String description;

    @MemberOrder(sequence = "3")
    @Column(allowsNull = "true")
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    @PropertyLayout(named = "Beschrijving")
    public String getDescription() {
        return description;
    }

    public void setDescription(final String summary) {
        this.description = summary;
    }





    @Programmatic
    public List<ProductElement> getElements() {
        return productElements.findByProduct(this);
    }










    @Inject
    DomainObjectContainer container;

    @Inject
    Stocks stocks;

    @Inject
    ProductElements productElements;


}
