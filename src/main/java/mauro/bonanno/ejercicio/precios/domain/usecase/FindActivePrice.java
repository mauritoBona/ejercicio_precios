package mauro.bonanno.ejercicio.precios.domain.usecase;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FindActivePrice {

    Prices execute(Long productID, Long brandID, LocalDateTime requestDate);
}
