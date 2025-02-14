package org.example.logPassException;

import java.util.List;

class UserValidator {
    public static boolean validate(User user) {
        List<Validator> validators = List.of(
                () -> {
                    if (user.getLogin().length() >= 20)
                        throw new WrongLoginException("Логин должен быть короче 20 символов.");
                },
                () -> {
                    if (user.getPassword().length() >= 20)
                        throw new WrongPasswordException("Пароль должен быть короче 20 символов.");
                },
                () -> {
                    if (!user.getPassword().equals(user.getConfirmPassword()))
                        throw new WrongPasswordException("Пароль и подтверждение не совпадают.");
                }
        );

        try {
            for (Validator validator : validators) {
                validator.validate();
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}


