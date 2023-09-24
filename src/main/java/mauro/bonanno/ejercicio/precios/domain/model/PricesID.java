package mauro.bonanno.ejercicio.precios.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PricesID implements Serializable {

    @Column(name = "BRAND_ID", nullable = false)
    private Long brandID;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productID;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;
}
