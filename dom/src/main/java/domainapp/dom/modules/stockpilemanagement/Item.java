package domainapp.dom.modules.stockpilemanagement;



import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.ObjectContracts;

import javax.jdo.annotations.*;

/**
 * Created by jonathan on 13-7-15.
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
public abstract class Item<T extends Item<T>>
extends AbstractDomainObject
        implements Comparable<T>{


    //region > title (property)
    private String title;

    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
    //endregion


//    //region > elements (property)
//    private SortedSet<ItemElement> elements = new TreeSet<>();
//
//    @CollectionLayout(render= RenderType.EAGERLY)
//    @Persistent(mappedBy = "item", dependentElement = "true")
//    public SortedSet<ItemElement> getElements() {
//        return elements;
//    }
//
//    public void setElements(final SortedSet<ItemElement> elements) {
//        this.elements = elements;
//    }
//
//    @Programmatic
//    public void addElement(final ItemElement element){
//        elements.add(element);
//    }
//    //endregion




    private final String keyProperties;

    public Item(final String keyProperties) {
        this.keyProperties=keyProperties;
    }

    protected String keyProperties() {
        return keyProperties;
    }



    @Override
    public int compareTo(final T other) {
        return ObjectContracts.compare(this, other, keyProperties);
    }








}
