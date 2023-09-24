package mauro.bonanno.ejercicio.precios.application.controller;

import mauro.bonanno.ejercicio.precios.application.exceptions.NotFoundException;
import mauro.bonanno.ejercicio.precios.application.response.ActivePriceDTO;
import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import mauro.bonanno.ejercicio.precios.domain.usecase.FindActivePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceController {

    private FindActivePrice findActivePrice;

    @Autowired
    public PriceController(@Autowired FindActivePrice findActivePrice) {
        this.findActivePrice = findActivePrice;
    }

    @GetMapping(value="/findActive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActivePriceDTO findActivePrice(@RequestParam("product_id") Long productID,
                                          @RequestParam("brand_id") Long brandID,
                                          @RequestParam(value = "date", required = false) LocalDateTime dateRequest) throws Exception {
        if (dateRequest == null) {
            dateRequest = LocalDateTime.now();
        }

        Prices activePrice = findActivePrice.execute(productID, brandID, dateRequest);

        if (activePrice == null) {
            throw new NotFoundException(String.format("Active Price not found by Product ID: %d - Brand ID: %d - Date Request: %s ",
                    productID, brandID, dateRequest));
        }

        return new ActivePriceDTO(activePrice.getId().getBrandID(), activePrice.getId().getProductID(),
                activePrice.getId().getStartDate(), activePrice.getId().getEndDate(),
                activePrice.getRate(), activePrice.getPrice(), activePrice.getCurrency());
    }
}
