package mauro.bonanno.ejercicio.precios.domain.usecase.impl;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import mauro.bonanno.ejercicio.precios.domain.repository.PriceRepository;
import mauro.bonanno.ejercicio.precios.domain.usecase.FindActivePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FindActivePriceImpl implements FindActivePrice {

    private PriceRepository priceRepository;

    @Autowired
    public FindActivePriceImpl(@Autowired PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Prices execute(Long productID, Long brandID, LocalDateTime requestDate) {
        return priceRepository.findActiveByProductIDBrandIDStarDateEndDateAndOrderByPriority(productID, brandID, requestDate);
    }

}