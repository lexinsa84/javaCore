package org.example;
import java.time.LocalDate;

import static org.example.Employee.calculateAverageAge;
import static org.example.Employee.calculateAverageSalary;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иван Иванов", "Менеджер", "123-456-789", 50000, LocalDate.of(1984, 12, 1)),
                new Employee("Петр Петров", "Разработчик", "234-567-890", 80000, LocalDate.of(1991, 4, 14)),
                new Employee("Сидор Сидоров", "Тестировщик", "345-678-901", 60000, LocalDate.of(2001, 5, 3)),
                new Employee("Анна Антонова", "Дизайнер", "456-789-012", 70000, LocalDate.of(1998, 8, 4)),
                new Director("Мария Миронова", "Директор", "567-890-123", 75000, LocalDate.of(1983, 5, 28))
        };

        System.out.println("Средний возраст сотрудников: " + calculateAverageAge(employees));
        System.out.println("Средняя зарплата сотрудников: " + calculateAverageSalary(employees));
        Director.raiseSalary(employees, 5);
        System.out.println("Повысили зарплату всем кроме директора:\n");
        for (Employee employee : employees) {
            System.out.println(employee.getInfo());
        }
        Employee.increaseSalary(employees,35,10);
        System.out.println("Повысили зарплату сотрудникам старше 35:\n");
        for (Employee employee : employees) {
            System.out.println(employee.getInfo());
        }

    }
}