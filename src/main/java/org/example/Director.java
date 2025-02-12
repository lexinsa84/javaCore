package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
public class Director extends Employee {
    public Director(String fullName, String position, String phone, double salary, LocalDate birthday) {
        super(fullName, position, phone, salary, birthday);
    }

    public static void raiseSalary(Employee[] employees, double percentage) {
        Arrays.stream(employees)
                .filter(employee -> !(employee instanceof Director))
                .forEach(employee -> employee.setSalary(employee.getSalary() * (1 + percentage / 100)));
    }
}
