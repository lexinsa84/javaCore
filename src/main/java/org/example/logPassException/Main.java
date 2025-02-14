package org.example.logPassException;

public class Main {
    public static void main(String[] args) {
        User user = UserInput.getUserData();
        boolean isValid = UserValidator.validate(user);
        System.out.println(STR."Результат проверки: \{isValid}");
    }
}
