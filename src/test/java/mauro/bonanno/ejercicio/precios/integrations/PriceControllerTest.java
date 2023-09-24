package mauro.bonanno.ejercicio.precios.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import mauro.bonanno.ejercicio.precios.PreciosApplication;
import mauro.bonanno.ejercicio.precios.application.controller.PriceController;
import mauro.bonanno.ejercicio.precios.application.response.ActivePriceDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PriceController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= PreciosApplication.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test 1: request at 10:00 a.m. on the 14th for product 35455 for brand 1 (XYZ)
    // Expect Brand 1 - Product 35455  - Start date: 2020-06-14T00:00:00 - end date: 2020-12-31T23:59:59
    // Rate: 10.00 - Price: 35.00 - Currency: EUR
    @Test
    public void test1_Request_10Am_Day_14_ForProduct_35455_AndBrand_1() throws Exception {
        MvcResult response = mockMvc.perform(get("/price/findActive")
                .param("product_id", "35455")
                .param("brand_id", "1")
                .param("date", "2020-06-14T10:00:00"))
                .andExpect(status().isOk()).andReturn();

        ActivePriceDTO result = objectMapper.readValue(response.getResponse().getContentAsString(), ActivePriceDTO.class);
        Assertions.assertEquals(1L, result.getBrandID());
        Assertions.assertEquals(35455L, result.getProductID());
        Assertions.assertEquals(new BigDecimal("10.00"), result.getRate());
        Assertions.assertEquals(new BigDecimal("35.00"), result.getPrice());
        Assertions.assertEquals("EUR", result.getCurrency());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 14, 0, 0,0),
                result.getStartDate());
        Assertions.assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59,59),
                result.getEndDate());
    }

    // Test 2: request at 4:00 p.m. on the 14th for product 35455 for brand 1 (XYZ)
    // Expect Brand 1 - Product 35455  - Start date: 2020-06-14 15:00:00 - end date: 2020-06-14 18:30:00
    // Rate: 8.00 - Price: 25.45 - Currency: EUR
    @Test
    public void test2_Request_4Pm_Day_14_ForProduct_35455_AndBrand_1() throws Exception {
        MvcResult response = mockMvc.perform(get("/price/findActive")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                        .param("date", "2020-06-14T16:00:00"))
                .andExpect(status().isOk()).andReturn();

        ActivePriceDTO result = objectMapper.readValue(response.getResponse().getContentAsString(), ActivePriceDTO.class);
        Assertions.assertEquals(1L, result.getBrandID());
        Assertions.assertEquals(35455L, result.getProductID());
        Assertions.assertEquals(new BigDecimal("8.00"), result.getRate());
        Assertions.assertEquals(new BigDecimal("25.45"), result.getPrice());
        Assertions.assertEquals("EUR", result.getCurrency());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 14, 15, 0,0),
                result.getStartDate());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 14, 18, 30,0),
                result.getEndDate());
    }

    // Test 3: request at 9:00 p.m. on day 14th for product 35455 for brand 1 (XYZ)
    // Expect Brand 1 - Product 35455  - Start date: 2020-06-14 15:00:00 - end date: 2020-06-14 18:30:00
    // Rate: 8.00 - Price: 25.45 - Currency: EUR
    @Test
    public void test3_Request_9Pm_Day_14_ForProduct_35455_AndBrand_1() throws Exception {
        MvcResult response = mockMvc.perform(get("/price/findActive")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                        .param("date", "2020-06-14T21:00:00"))
                .andExpect(status().isOk()).andReturn();

        ActivePriceDTO result = objectMapper.readValue(response.getResponse().getContentAsString(), ActivePriceDTO.class);
        Assertions.assertEquals(1L, result.getBrandID());
        Assertions.assertEquals(35455L, result.getProductID());
        Assertions.assertEquals(new BigDecimal("8.00"), result.getRate());
        Assertions.assertEquals(new BigDecimal("25.45"), result.getPrice());
        Assertions.assertEquals("EUR", result.getCurrency());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 14, 15, 0,0),
                result.getStartDate());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 14, 18, 30,0),
                result.getEndDate());
    }

    // Test 4: request at 10:00 a.m. on the 15th for product 35455 for brand 1 (XYZ) 2020-06-15 10:00:00
    // Expect Brand 1 - Product 35455  - Start date: 2020-06-15 00:00:00 - end date: 2020-06-15 11:00:00
    // Rate: 9.20 - Price: 30.50 - Currency: EUR
    @Test
    public void test4_Request_10Am_Day_15_ForProduct_35455_AndBrand_1() throws Exception {
        MvcResult response = mockMvc.perform(get("/price/findActive")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                        .param("date", "2020-06-15T10:00:00"))
                .andExpect(status().isOk()).andReturn();

        ActivePriceDTO result = objectMapper.readValue(response.getResponse().getContentAsString(), ActivePriceDTO.class);

        Assertions.assertEquals(1L, result.getBrandID());
        Assertions.assertEquals(35455L, result.getProductID());
        Assertions.assertEquals(new BigDecimal("9.20"), result.getRate());
        Assertions.assertEquals(new BigDecimal("30.50"), result.getPrice());
        Assertions.assertEquals("EUR", result.getCurrency());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 15, 0, 0,0),
                result.getStartDate());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 15, 11, 0,0),
                result.getEndDate());
    }

    // Test 5: request at 9:00 p.m. on day 16th for product 35455 for brand 1 (XYZ) 2020-06-16 21:00:00
    // Expect Brand 1 - Product 35455  - Start date: 2020-06-15 16:00:00 - end date: 2020-12-31 23:59:50
    // Rate: 10.00 - Price: 38.95 - Currency: EUR
    @Test
    public void test5_Request_10Am_Day_15_ForProduct_35455_AndBrand_1() throws Exception {
        MvcResult response = mockMvc.perform(get("/price/findActive")
                        .param("product_id", "35455")
                        .param("brand_id", "1")
                        .param("date", "2020-06-16T21:00:00"))
                .andExpect(status().isOk()).andReturn();

        ActivePriceDTO result = objectMapper.readValue(response.getResponse().getContentAsString(), ActivePriceDTO.class);
        Assertions.assertEquals(1L, result.getBrandID());
        Assertions.assertEquals(35455L, result.getProductID());
        Assertions.assertEquals(new BigDecimal("10.00"), result.getRate());
        Assertions.assertEquals(new BigDecimal("38.95"), result.getPrice());
        Assertions.assertEquals("EUR", result.getCurrency());
        Assertions.assertEquals(LocalDateTime.of(2020, 6, 15, 16, 0,0),
                result.getStartDate());
        Assertions.assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59,59),
                result.getEndDate());
    }



    @Test
    public void RequestWithoutProductID_BadRequest() throws Exception {
        mockMvc.perform(get("/price/findActive")
                        .param("brand_id", "1")
                        .param("date", "2020-06-16T21:00:00"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void RequestWithoutBrandID_BadRequest() throws Exception {
        mockMvc.perform(get("/price/findActive")
                        .param("product_id", "1")
                        .param("date", "2020-06-16T21:00:00"))
                .andExpect(status().isBadRequest());
    }
}
