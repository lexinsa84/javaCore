package InterShop;

public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        ProductManager productManager = new ProductManager();
        OrderManager orderManager = new OrderManager(customerManager, productManager);

        // Заполняем покупателей
        customerManager.addCustomer(new Customer("Иван Петров", 30, "+79001234567"));
        customerManager.addCustomer(new Customer("Мария Сидорова", 25, "+79161112233"));

        // Заполняем товары
        productManager.addProduct(new Product("Ноутбук", 55000));
        productManager.addProduct(new Product("Смартфон", 32000));
        productManager.addProduct(new Product("Планшет", 27000));
        productManager.addProduct(new Product("Монитор", 15000));
        productManager.addProduct(new Product("Клавиатура", 5000));

        // Совершаем покупки
        orderManager.processPurchase("Иван Петров", "Ноутбук", "2");
        orderManager.processPurchase("Мария Сидорова", "Смартфон", "101");
        orderManager.processPurchase("Мария Сидорова", "Телевизор", "1");
        orderManager.processPurchase("Мария Сидорова", "Клавиатура", "-5");
        orderManager.processPurchase("Пётр Иванов", "Ноутбук", "1");

        // Вывод заказов
        orderManager.printOrders();
    }
}
