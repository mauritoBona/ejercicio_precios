package mauro.bonanno.ejercicio.precios.units;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Utils {

    public static Prices buildPrices(Long brandID, Long productID, LocalDateTime startDate, LocalDateTime endDate,
                               BigDecimal price, BigDecimal rate) {
        Prices.PricesBuilder builder = Prices.builder();
        builder.brandID(brandID)
                .productID(productID)
                .startDate(startDate)
                .endDate(endDate)
                .price(price)
                .rate(rate);

        return builder.build();
    }

}
