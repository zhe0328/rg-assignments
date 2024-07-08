package org.example.employeespringbootjpa.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee Mariam = new Employee(
                    "Mariam",
                    "finance");
            Employee Alice = new Employee(
                    "Alice",
                    "technology");
            Employee Bob = new Employee(
                    "Bob",
                    "HR");
            employeeRepository.saveAll(List.of(Mariam, Alice, Bob));
        };
    }
}
