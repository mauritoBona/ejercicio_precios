package mauro.bonanno.ejercicio.precios.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="PRICES")
public class Prices {

    @EmbeddedId
    private PricesID priceID;

    @Column(name = "PRICE_LIST", nullable = false)
    private Long priceList;

    @Column(name = "PRIORITY", nullable = false)
    private Long priority;

    @Column(name = "PRICE", nullable = false, precision=20, scale=2)
    private BigDecimal price;

    @Column(name = "RATE", nullable = false, precision=20, scale=2)
    private BigDecimal rate;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    public PricesID getPriceID() {
        return priceID;
    }

    public void setPriceID(PricesID priceID) {
        this.priceID = priceID;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static Prices.PricesBuilder builder() {
        return new Prices.PricesBuilder();
    }
    public static final class PricesBuilder {

        private Prices prices;

        public PricesBuilder() {
            prices = new Prices();
            prices.setPriceID(new PricesID());
        }

        public Prices.PricesBuilder productID(Long productID) {
            prices.getPriceID().setProductID(productID);
            return this;
        }

        public Prices.PricesBuilder brandID(Long brandID) {
            prices.getPriceID().setBrandID(brandID);
            return this;
        }

        public Prices.PricesBuilder startDate(LocalDateTime startDate) {
            prices.getPriceID().setStartDate(startDate);
            return this;
        }

        public Prices.PricesBuilder endDate(LocalDateTime endDate) {
            prices.getPriceID().setEndDate(endDate);
            return this;
        }

        public Prices.PricesBuilder priceList(Long priceList) {
            prices.setPriceList(priceList);
            return this;
        }

        public Prices.PricesBuilder priority(Long priority) {
            prices.setPriority(priority);
            return this;
        }

        public Prices.PricesBuilder price(BigDecimal price) {
            prices.setPrice(price);
            return this;
        }

        public Prices.PricesBuilder rate(BigDecimal rate) {
            prices.setRate(rate);
            return this;
        }

        public Prices.PricesBuilder currency(String currency) {
            prices.setCurrency(currency);
            return this;
        }

        public Prices build() {
            return prices;
        }
    }
}
