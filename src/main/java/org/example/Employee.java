package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;

@Data
@AllArgsConstructor
public class Employee {
    private String fullName;
    private String position;
    private String phone;
    private double salary;
    private LocalDate birthday;

    public String getInfo() {
        return this.toString();
    }

    public static void increaseSalary(Employee[] employees, int age, double increaseAmount) {
        LocalDate today = LocalDate.now();
        Arrays.stream(employees)
                .filter(employee -> Period.between(employee.getBirthday(), today).getYears() > age)
                .forEach(employee -> employee.setSalary(employee.getSalary() * (1 + increaseAmount / 100)));
    }

    public static double calculateAverageAge(Employee[] employees) {
        LocalDate today = LocalDate.now();

        return Arrays.stream(employees)
                .mapToInt(employee -> Period.between(employee.getBirthday(), today).getYears())
                .average()
                .orElse(0);
    }

    public static double calculateAverageSalary(Employee[] employees) {
        return Arrays.stream(employees)
                .mapToInt(employee -> (int) employee.getSalary())
                .average().
                orElse(0);
    }

    public static Comparator<Employee> compareDate() {
        return Comparator.comparing(employee -> employee.birthday);
    }
}
