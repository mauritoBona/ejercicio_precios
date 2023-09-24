package mauro.bonanno.ejercicio.precios.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

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


}
