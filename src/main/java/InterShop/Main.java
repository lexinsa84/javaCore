package InterShop;

import InterShop.models.Customer;
import InterShop.models.Gender;
import InterShop.models.Holiday;
import InterShop.services.CongratulationService;
import InterShop.services.PurchaseService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PurchaseService purchaseService = new PurchaseService();
        purchaseService.processOrders();
        purchaseService.printSummary();

        List<Customer> employees = Arrays.asList(
                new Customer("Иван Иванов", 30, "123456789", Gender.MALE),
                new Customer("Мария Петрова", 25, "987654321", Gender.FEMALE)
        );

        CongratulationService congratulationService = new CongratulationService();
        congratulationService.congratulateEmployees(employees, Holiday.NO_HOLIDAY);
    }
}
