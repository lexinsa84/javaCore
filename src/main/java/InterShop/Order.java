package InterShop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Customer customer;
    private Product product;
    private int quantity;

    @Override
    public String toString() {
        return customer.getName() + " купил " + product.getName() + " в количестве " + quantity + " шт.";
    }
}
