package mauro.bonanno.ejercicio.precios.application.controller;

import mauro.bonanno.ejercicio.precios.application.response.ActivePriceDTO;
import mauro.bonanno.ejercicio.precios.domain.usecase.FindActivePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private FindActivePrice findActivePrice;

    @RequestMapping(value="/findActivePrice", method = RequestMethod.GET)
    public ActivePriceDTO findActivePrice(@RequestParam("product_id") Long productID,
                                          @RequestParam("brand_id") Long brandID,
                                          @RequestParam("date") LocalDateTime dateRequest) {

        return new ActivePriceDTO();
    }
}
