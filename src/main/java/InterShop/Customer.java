package InterShop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private int age;
    private String phone;

    @Override
    public String toString() {
        return name + " (" + age + " лет, " + phone + ")";
    }
}
