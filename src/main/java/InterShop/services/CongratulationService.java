package InterShop.services;



import InterShop.models.Customer;
import InterShop.models.Gender;
import InterShop.models.Holiday;

import java.time.LocalDate;
import java.util.List;

public class CongratulationService implements ICongratulationService {

    @Override
    public void congratulateEmployees(List<Customer> customers, Holiday holiday) {
        LocalDate today = LocalDate.now();

        // Определяем праздник
        switch (today.getMonthValue()) {
            case 1 -> holiday = Holiday.NEW_YEAR;
            case 3 -> holiday = (today.getDayOfMonth() == 8) ? Holiday.WOMEN_DAY : Holiday.NO_HOLIDAY;
            case 2 -> holiday = (today.getDayOfMonth() == 23) ? Holiday.DEFENDER_DAY : Holiday.NO_HOLIDAY;
            default -> holiday = Holiday.NO_HOLIDAY;
        }

        for (Customer customer : customers) {
            if (holiday == Holiday.NEW_YEAR) {
                System.out.println("🎄 С Новым Годом, " + customer.getFullName() + "!");
            } else if (holiday == Holiday.WOMEN_DAY && customer.getGender() == Gender.FEMALE) {
                System.out.println("🌸 С 8 Марта, " + customer.getFullName() + "!");
            } else if (holiday == Holiday.DEFENDER_DAY && customer.getGender() == Gender.MALE) {
                System.out.println("🛡 С 23 Февраля, " + customer.getFullName() + "!");
            }
        }
    }
}

