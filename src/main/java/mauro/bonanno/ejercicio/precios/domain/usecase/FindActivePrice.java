package mauro.bonanno.ejercicio.precios.domain.usecase;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public interface FindActivePrice {

    Prices execute(Long productID, Long brandID, LocalDateTime requestDate);
}
