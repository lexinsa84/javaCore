package InterShop.services;

import InterShop.models.Customer;
import InterShop.models.Holiday;

import java.util.List;

public interface ICongratulationService {
    void congratulateEmployees(List<Customer> customers, Holiday holiday);
}
