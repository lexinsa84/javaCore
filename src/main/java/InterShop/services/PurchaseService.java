package InterShop.services;

import InterShop.exceptions.AmountException;
import InterShop.exceptions.CustomerException;
import InterShop.exceptions.ProductException;
import InterShop.models.Customer;
import InterShop.models.Gender;
import InterShop.models.Order;
import InterShop.models.Product;

import java.util.Arrays;
import java.util.List;

public class PurchaseService implements IPurchaseService {
    private final List<Customer> customers = Arrays.asList(
            new Customer("Иван Иванов", 30, "123456789", Gender.MALE),
            new Customer("Мария Петрова", 25, "987654321", Gender.FEMALE)
    );

    private final List<Product> products = Arrays.asList(
            new Product("Телефон", 50000),
            new Product("Ноутбук", 100000)
    );

    private final Order[] orders = new Order[5];
    private int orderCount = 0;

    @Override
    public Order makePurchase(String customerName, String productName, int quantity) {
        Customer customer = customers.stream()
                .filter(c -> c.getFullName().equalsIgnoreCase(customerName))
                .findFirst()
                .orElseThrow(() -> new CustomerException("Ошибка: Покупатель не найден!"));

        Product product = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new ProductException("Ошибка: Товар не найден!"));

        if (quantity <= 0 || quantity >= 100) {
            throw new AmountException("Ошибка: Некорректное количество товара!");
        }

        return new Order(customer, product, quantity);
    }

    @Override
    public void processOrders() {
        String[][] purchaseRequests = {
                {"Иван Иванов", "Ноутбук", "1"},
                {"Мария Петрова", "Телефон", "101"},
                {"Неизвестный", "Телефон", "1"}
        };

        for (String[] request : purchaseRequests) {
            try {
                orders[orderCount++] = makePurchase(request[0], request[1], Integer.parseInt(request[2]));
            } catch (ProductException e) {
                System.out.println(e.getMessage());
            } catch (AmountException e) {
                System.out.println(e.getMessage() + " Покупаем 1 шт.");
                orders[orderCount++] = new Order(customers.get(0), products.get(0), 1);
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    @Override
    public void printSummary() {
        System.out.println("Итоговое количество совершённых покупок: " + orderCount);
    }
}

