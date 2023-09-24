package mauro.bonanno.ejercicio.precios.domain.usecase.impl;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import mauro.bonanno.ejercicio.precios.domain.usecase.FindActivePrice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FindActivePriceImpl implements FindActivePrice {

    @Override
    public Prices execute(Long productID, Long brandID, LocalDateTime requestDate) {
        return null;
    }
}
