package org.example.logPassException;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private final String login;
    private final String password;
    private final String confirmPassword;
}



