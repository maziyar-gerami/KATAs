package productinventorystatistics;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductService {

    public static Map<String, Integer> totalValueByCategory(List<Product> products){
        if (products == null || products.isEmpty())
            return Map.of();

        return products.stream()
                .filter(validateCategory())
                .collect(Collectors.groupingBy(Product::category , Collectors.summingInt(Product::price)));
    }

    private static Predicate<Product> validateCategory() {
        return product -> product.category() != null && !product.category().isBlank() && product.price() >= 0;
    }
}
