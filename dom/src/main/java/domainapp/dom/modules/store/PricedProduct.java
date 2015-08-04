package domainapp.dom.modules.store;

import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElements;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Image;
import org.apache.isis.applib.value.Money;

import javax.inject.Inject;
import javax.jdo.annotations.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by jonathan on 26-7-15.
 */

@PersistenceCapable(identityType = IdentityType.DATASTORE)
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject
public class PricedProduct extends Product {




    //region > sellingPrice (property)
    private BigDecimal sellingPrice;



    @MemberOrder(sequence = "5")
    @Column(allowsNull = "false")
    @PropertyLayout(named = "Verkoopprijs")
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(final BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    //endregion





    //region > costPrice (property)
    private BigDecimal costPrice;

    @MemberOrder(sequence = "6")
    @Column(allowsNull = "false")
    @PropertyLayout(named = "Inkoopprijs")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(final BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    //endregion


    //TODO foto

    //region > image (property)
    private Blob image;



    @MemberOrder(sequence = "1")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @Column(name = "attachment_name"),
            @Column(name = "attachment_mimetype"),
            @Column(name = "attachment_bytes", jdbcType = "BLOB", sqlType = "BLOB")
    })
    @Property(
            optionality = Optionality.OPTIONAL
    )
    public Blob getImage() {
        return image;
    }

    public void setImage(final Blob image) {
        this.image = image;
    }

    //region > addImage (action)
    @MemberOrder(sequence = "1", name = "General")
    @Action
    @ActionLayout(named = "Voeg foto toe")
    public PricedProduct addImage(final Blob image) {
        setImage(image);
        return this;
    }
    //endregion





    @Inject
    DomainObjectContainer container;



}
