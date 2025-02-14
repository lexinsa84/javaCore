package InterShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CustomerManager {
    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomer(String name) {
        return customers.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new CustomerException("Покупатель не найден: " + name));
    }
}

