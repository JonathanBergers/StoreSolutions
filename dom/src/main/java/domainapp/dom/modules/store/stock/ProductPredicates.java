package domainapp.dom.modules.store.stock;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import org.joda.time.LocalDate;

import javax.lang.model.element.TypeParameterElement;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * Created by jonathan on 25-7-15.
 */
public class ProductPredicates {


        public static Predicate<Product> thoseWithTitle(final String title) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return Objects.equal(product.getTitle().toLowerCase(), title.toLowerCase());
                }
            };
        }


        public static Predicate<Product> thoseWithTitleBegins(final String title) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return Objects.equal(product.getTitle().toLowerCase().startsWith(title.toLowerCase()), true);
                }
            };
        }


        public static Predicate<Product> thoseWithCostPrice(final BigDecimal costPrice) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getCostPrice().compareTo(costPrice) == 0;
                }
            };
        }

        public static Predicate<Product> thoseWithCostHigherThan(final BigDecimal costPrice) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getCostPrice().compareTo(costPrice) == 1;
                }
            };
        }

        public static Predicate<Product> thoseWithCostLowerThan(final BigDecimal costPrice) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getCostPrice().compareTo(costPrice) == -1;
                }
            };
        }


        public static Predicate<Product> thoseWithSellingPrice(final BigDecimal sellingPrice) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getSellingPrice().compareTo(sellingPrice) == 0;
                }
            };
        }

        public static Predicate<Product> thoseWithSellingPriceHigherThan(final BigDecimal sellingPrice) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getSellingPrice().compareTo(sellingPrice) == 1;
                }
            };
        }

        public static Predicate<Product> thoseWithSellingPriceLowerThan(final BigDecimal sellingPrice) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getSellingPrice().compareTo(sellingPrice) == -1;
                }
            };
        }


        public static Predicate<Product> thoseWithAmount(final Integer amount) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getAmount().compareTo(amount) == 0;
                }
            };
        }

        public static Predicate<Product> thoseWithAmountHigherThan(final Integer amount) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getAmount().compareTo(amount) == 1;
                }
            };
        }


        public static Predicate<Product> thoseWithAmountLowerThan(final Integer amount) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getAmount().compareTo(amount) == -1;
                }
            };
        }





    public static class WithDate{
        public static Predicate<ProductWithDate> thoseAtDate(final LocalDate date) {
            return new Predicate<ProductWithDate>() {
                @Override
                public boolean apply(final ProductWithDate product) {

                    return product.getTimeStamp().toLocalDate().compareTo(date) == 0;
                }
            };
        }



        public static Predicate<ProductWithDate> thoseBeforeDate(final LocalDate date) {
            return new Predicate<ProductWithDate>() {
                @Override
                public boolean apply(final ProductWithDate product) {

                    return product.getTimeStamp().toLocalDate().compareTo(date) == 1;
                }
            };
        }

        public static Predicate<ProductWithDate> thoseAfterDate(final LocalDate date) {
            return new Predicate<ProductWithDate>() {
                @Override
                public boolean apply(final ProductWithDate product) {

                    return product.getTimeStamp().toLocalDate().compareTo(date) == 1;
                }
            };
        }







    }




}
