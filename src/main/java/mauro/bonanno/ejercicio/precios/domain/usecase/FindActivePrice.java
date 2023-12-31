package mauro.bonanno.ejercicio.precios.domain.usecase;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;

import java.time.LocalDateTime;

public interface FindActivePrice {

    Prices execute(Long productID, Long brandID, LocalDateTime requestDate);
}
