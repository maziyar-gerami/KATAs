package productinventorystatistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceTest {

    @ParameterizedTest
    @NullAndEmptySource
    void productInventoryStatistics_whenProductsAreEmpty_returnEmptyMap(List<Product> products) {
        var result = ProductService.totalValueByCategory(products);
        assertEquals(Map.of(), result);
    }

    @Test
    void productInventoryStatistics_whenWheProductsAreValid_returnResult() {
        var products = of(
                new Product("Laptop", "Electronics", 1000),
                new Product("Phone", "Electronics", 500),
                new Product("Desk", "Furniture", 300),
                new Product("chair", "   ", 300),
                new Product("chair", null, 300));

        var expectedResult = Map.of("Electronics", 1500, "Furniture", 300);
        var result = ProductService.totalValueByCategory(products);

        assertEquals(expectedResult, result);
    }
}