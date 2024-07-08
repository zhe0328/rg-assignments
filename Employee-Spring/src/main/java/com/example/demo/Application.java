package com.example.demo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        // Create a new employee
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setDepartment("HR");
        employeeDAO.save(employee);

        // Find employee by ID
        Employee retrievedEmployee = employeeDAO.findById(1);
        System.out.println("Retrieved Employee: " + retrievedEmployee.toString());

        // Update employee
        retrievedEmployee.setDepartment("Finance");
        employeeDAO.update(retrievedEmployee);
        Employee updatedEmployee = employeeDAO.findById(1);
        System.out.println("Updated Employee: " + updatedEmployee.toString());

        // Delete employee
        employeeDAO.delete(1);

        context.close();
    }
}
