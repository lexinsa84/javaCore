package org.example.logPassException;

class WrongPasswordException extends Exception {

    public WrongPasswordException() {
        super("Некорректный пароль!");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
