package mauro.bonanno.ejercicio.precios.units.usacase;

import mauro.bonanno.ejercicio.precios.domain.model.Prices;
import mauro.bonanno.ejercicio.precios.domain.repository.PriceRepository;
import mauro.bonanno.ejercicio.precios.domain.usecase.FindActivePrice;
import mauro.bonanno.ejercicio.precios.domain.usecase.impl.FindActivePriceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static mauro.bonanno.ejercicio.precios.units.Utils.buildPrices;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindActivePriceTest {
    private FindActivePrice findActivePrice;

    @Mock
    private PriceRepository priceRepository;

    @Before
    public void setUp() {
        this.priceRepository = mock(PriceRepository.class);
        this.findActivePrice = new FindActivePriceImpl(priceRepository);
    }

    @Test
    @DisplayName("Test donde se encuentra un precio activo")
    public void Test_GetActivePrice() {
        Long brandID = 1L;
        Long productID = 2L;
        LocalDateTime requestDate = LocalDateTime.now();
        Prices prices = buildPrices(1L, 2L, requestDate.minusDays(1), requestDate.plusHours(2),
                BigDecimal.TEN, BigDecimal.ONE);

        when(this.priceRepository.findActiveByProductIDBrandIDStarDateEndDateAndOrderByPriority(
                productID, brandID, requestDate)).thenReturn(prices);

        Prices result = this.findActivePrice.execute(productID, brandID, requestDate);

        Assertions.assertEquals(brandID, result.getId().getBrandID());
        Assertions.assertEquals(productID, result.getId().getProductID());
        Assertions.assertEquals(prices.getId().getStartDate(), result.getId().getStartDate());
        Assertions.assertEquals(prices.getId().getEndDate(), result.getId().getEndDate());
        Assertions.assertEquals(prices.getRate(), result.getRate());
        Assertions.assertEquals(prices.getPrice(), result.getPrice());
    }

    @Test
    @DisplayName("Test donde no se encuentra un precio activo, se obtiene un null")
    public void Test_NotFoundActivePrice() {
        Long brandID = 1L;
        Long productID = 2L;
        LocalDateTime requestDate = LocalDateTime.now();

        when(this.priceRepository.findActiveByProductIDBrandIDStarDateEndDateAndOrderByPriority(
                productID, brandID, requestDate)).thenReturn(null);

        Prices result = this.findActivePrice.execute(productID, brandID, requestDate);

        Assertions.assertNull(result);
    }

    @Test(expected = Exception.class)
    @DisplayName("Test donde el repositorio lanza una excepcion")
    public void Test_RepositoryThrowException() {
        Long brandID = 1L;
        Long productID = 2L;
        LocalDateTime requestDate = LocalDateTime.now();

        when(this.priceRepository.findActiveByProductIDBrandIDStarDateEndDateAndOrderByPriority(
                productID, brandID, requestDate)).thenThrow(new Exception("TEST"));

        Prices result = this.findActivePrice.execute(productID, brandID, requestDate);

        Assertions.assertNull(result);
    }
}
