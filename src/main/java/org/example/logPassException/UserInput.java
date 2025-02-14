package org.example.logPassException;

import java.util.Scanner;

class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static User getUserData() {
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        return new User(login, password, confirmPassword);
    }
}
