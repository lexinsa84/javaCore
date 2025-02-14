package InterShop;

import java.util.ArrayList;
import java.util.List;

class OrderManager {
    private final List<Order> orders = new ArrayList<>();
    private final CustomerManager customerManager;
    private final ProductManager productManager;

    public OrderManager(CustomerManager customerManager, ProductManager productManager) {
        this.customerManager = customerManager;
        this.productManager = productManager;
    }

    public void processPurchase(String customerName, String productName, String quantityStr) {
        try {
            orders.add(makePurchase(customerName, productName, quantityStr));
        } catch (ProductException e) {
            System.out.println(e.getMessage()); // Неверный товар → просто сообщение
        } catch (AmountException e) {
            System.out.println(e.getMessage() + " Покупаем 1 шт.");
            try {
                orders.add(makePurchase(customerName, productName, "1"));
            } catch (CustomerException | ProductException | AmountException ex) {
                System.out.println("Ошибка при повторной попытке: " + ex.getMessage());
            }
        } catch (CustomerException e) {
            throw new RuntimeException("Критическая ошибка: " + e.getMessage());
        }
    }

    private Order makePurchase(String customerName, String productName, String quantityStr) {
        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            throw new AmountException("Ошибка: Некорректный формат количества: " + quantityStr);
        }

        if (quantity <= 0 || quantity > 100) {
            throw new AmountException("Ошибка: Количество товара должно быть от 1 до 100.");
        }

        Customer customer = customerManager.findCustomer(customerName);
        Product product = productManager.findProduct(productName);

        return new Order(customer, product, quantity);
    }

    public void printOrders() {
        System.out.println("\nСписок заказов:");
        orders.forEach(System.out::println);
        System.out.println("\nВсего совершено покупок: " + orders.size());
    }
}

