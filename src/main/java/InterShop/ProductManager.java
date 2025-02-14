package InterShop;

import java.util.ArrayList;
import java.util.List;

class ProductManager {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProduct(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ProductException("Товар не найден: " + name));
    }
}

