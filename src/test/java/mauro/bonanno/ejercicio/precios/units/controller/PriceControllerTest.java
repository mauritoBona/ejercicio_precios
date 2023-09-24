package mauro.bonanno.ejercicio.precios.units.controller;

import mauro.bonanno.ejercicio.precios.application.controller.PriceController;
import mauro.bonanno.ejercicio.precios.application.exceptions.NotFoundException;
import mauro.bonanno.ejercicio.precios.application.response.ActivePriceDTO;
import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import mauro.bonanno.ejercicio.precios.domain.usecase.FindActivePrice;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static mauro.bonanno.ejercicio.precios.units.Utils.buildPrices;
import static org.mockito.Mockito.*;

public class PriceControllerTest {

    private PriceController priceController;

    @Mock
    private FindActivePrice findActivePrice;

    @Before
    public void setUp() {
        this.findActivePrice = mock(FindActivePrice.class);
        this.priceController = new PriceController(findActivePrice);
    }

    @Test
    @DisplayName("Test donde se pasan todos los parametros y se encuentra resultado")
    public void Test_ActivePriceFound() throws Exception {
        Long brandID = 1L;
        Long productID = 2L;
        LocalDateTime requestDate = LocalDateTime.now();
        Prices prices = buildPrices(1L, 2L, requestDate.minusDays(1), requestDate.plusHours(2),
                BigDecimal.TEN, BigDecimal.ONE);

        when(this.findActivePrice.execute(productID, brandID, requestDate)).thenReturn(prices);

        ActivePriceDTO result = this.priceController.findActivePrice(productID, brandID, requestDate);

        Assertions.assertEquals(brandID, result.getBrandID());
        Assertions.assertEquals(productID, result.getProductID());
        Assertions.assertEquals(prices.getId().getStartDate(), result.getStartDate());
        Assertions.assertEquals(prices.getId().getEndDate(), result.getEndDate());
        Assertions.assertEquals(prices.getRate(), result.getRate());
        Assertions.assertEquals(prices.getPrice(), result.getPrice());
    }

    @Test(expected = NotFoundException.class)
    @DisplayName("Test donde se pasan todos los parametros y no se encuentra resultado")
    public void Test_NotActivePriceFound() throws Exception {
        Long brandID = 1L;
        Long productID = 2L;
        LocalDateTime requestDate = LocalDateTime.now();

        when(this.findActivePrice.execute(productID, brandID, requestDate)).thenReturn(null);

        this.priceController.findActivePrice(productID, brandID, requestDate);
    }

    @Test
    @DisplayName("Test donde no se pasa el date, se obtiene resultado")
    public void Test_getWithoutDateRequest_getResult() throws Exception {
        Long brandID = 1L;
        Long productID = 2L;
        LocalDateTime requestDate = LocalDateTime.now();
        Prices prices = buildPrices(1L, 2L, requestDate.minusDays(1), requestDate.plusHours(2),
                BigDecimal.TEN, BigDecimal.ONE);

        when(this.findActivePrice.execute(eq(productID), eq(brandID), any(LocalDateTime.class)))
                .thenReturn(prices);

        ActivePriceDTO result = this.priceController.findActivePrice(productID, brandID, null);

        Assertions.assertEquals(brandID, result.getBrandID());
        Assertions.assertEquals(productID, result.getProductID());
        Assertions.assertEquals(prices.getId().getStartDate(), result.getStartDate());
        Assertions.assertEquals(prices.getId().getEndDate(), result.getEndDate());
        Assertions.assertEquals(prices.getRate(), result.getRate());
        Assertions.assertEquals(prices.getPrice(), result.getPrice());
    }

}
