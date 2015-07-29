package domainapp.dom.util;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.element.ProductElement;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import domainapp.dom.modules.store.PricedProduct;

import java.math.BigDecimal;

/**
 * Created by jonathan on 25-7-15.
 */
public class StorePredicates {


    public static class ProductPredicate {

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


        public static Predicate<Product> thoseWithDescriptionContains(final String text) {
            return new Predicate<Product>() {
                @Override
                public boolean apply(final Product product) {
                    return product.getDescription().toLowerCase().contains(text.toLowerCase());
                }
            };
        }

    }

    public static class PricedProductPredicate {

        public static Predicate<PricedProduct> thoseWithCostPrice(final BigDecimal costPrice) {
            return new Predicate<PricedProduct>() {
                @Override
                public boolean apply(final PricedProduct product) {
                    return product.getCostPrice().compareTo(costPrice) == 0;
                }
            };
        }

        public static Predicate<PricedProduct> thoseWithCostHigherThan(final BigDecimal costPrice) {
            return new Predicate<PricedProduct>() {
                @Override
                public boolean apply(final PricedProduct product) {
                    return product.getCostPrice().compareTo(costPrice) == 1;
                }
            };
        }

        public static Predicate<PricedProduct> thoseWithCostLowerThan(final BigDecimal costPrice) {
            return new Predicate<PricedProduct>() {
                @Override
                public boolean apply(final PricedProduct product) {
                    return product.getCostPrice().compareTo(costPrice) == -1;
                }
            };
        }


        public static Predicate<PricedProduct> thoseWithSellingPrice(final BigDecimal sellingPrice) {
            return new Predicate<PricedProduct>() {
                @Override
                public boolean apply(final PricedProduct product) {
                    return product.getSellingPrice().compareTo(sellingPrice) == 0;
                }
            };
        }

        public static Predicate<PricedProduct> thoseWithSellingPriceHigherThan(final BigDecimal sellingPrice) {
            return new Predicate<PricedProduct>() {
                @Override
                public boolean apply(final PricedProduct product) {
                    return product.getSellingPrice().compareTo(sellingPrice) == 1;
                }
            };
        }

        public static Predicate<PricedProduct> thoseWithSellingPriceLowerThan(final BigDecimal sellingPrice) {
            return new Predicate<PricedProduct>() {
                @Override
                public boolean apply(final PricedProduct product) {
                    return product.getSellingPrice().compareTo(sellingPrice) == -1;
                }
            };
        }


    }



    public static class StockPredicate {


        public static Predicate<Stock> thoseWithAmount(final Integer amount) {
            return new Predicate<Stock>() {
                @Override
                public boolean apply(final Stock stock) {
                    return stock.getAmount().compareTo(amount) == 0;
                }
            };
        }

        public static Predicate<Stock> thoseWithAmountMoreThan(final Integer amount) {
            return new Predicate<Stock>() {
                @Override
                public boolean apply(final Stock stock) {
                    return stock.getAmount().compareTo(amount) == 1;
                }
            };
        }


        public static Predicate<Stock> thoseWithAmountLessThan(final Integer amount) {
            return new Predicate<Stock>() {
                @Override
                public boolean apply(final Stock stock) {
                    return stock.getAmount().compareTo(amount) == -1;
                }
            };
        }

        public static Predicate<Stock> thoseWithProduct(final Product product) {
            return new Predicate<Stock>() {
                @Override
                public boolean apply(final Stock stock) {
                    return Objects.equal(stock.getProduct(), product);
                }
            };
        }

    }
    public static class ProductElementPredicates{


        public static Predicate<ProductElement> thoseWithType(final String type) {
            return new Predicate<ProductElement>() {
                @Override
                public boolean apply(final ProductElement productElement) {
                    return productElement.getType().toLowerCase().equals(type.toLowerCase());
                }
            };
        }
        public static Predicate<ProductElement> thoseWithTypeContains(final String type) {
            return new Predicate<ProductElement>() {
                @Override
                public boolean apply(final ProductElement productElement) {
                    return productElement.getType().toLowerCase().contains(type.toLowerCase());
                }
            };
        }

        public static Predicate<ProductElement> thoseWithProduct(final Product product) {
            return new Predicate<ProductElement>() {
                @Override
                public boolean apply(final ProductElement productElement) {
                    return Objects.equal(productElement.getProduct(), product);
                }
            };
        }


    }





//
//
//    public static class WithDate{
//        public static Predicate<ProductStock> thoseAtDate(final LocalDate date) {
//            return new Predicate<ProductStock>() {
//                @Override
//                public boolean apply(final ProductStock product) {
//
//                    return product.getTimeStamp().toLocalDate().compareTo(date) == 0;
//                }
//            };
//        }
//
//
//
//        public static Predicate<ProductStock> thoseBeforeDate(final LocalDate date) {
//            return new Predicate<ProductStock>() {
//                @Override
//                public boolean apply(final ProductStock product) {
//
//                    return product.getTimeStamp().toLocalDate().compareTo(date) == 1;
//                }
//            };
//        }
//
//        public static Predicate<ProductStock> thoseAfterDate(final LocalDate date) {
//            return new Predicate<ProductStock>() {
//                @Override
//                public boolean apply(final ProductStock product) {
//
//                    return product.getTimeStamp().toLocalDate().compareTo(date) == 1;
//                }
//            };
//        }
//






   }





