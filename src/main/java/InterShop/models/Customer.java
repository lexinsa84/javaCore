package InterShop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class Customer {
    private String fullName;
    private int age;
    private String phone;
    private Gender gender;
}
