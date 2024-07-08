package org.example.employeespringbootjpa.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Integer id, String name, String department) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Employee with id " + id + " does not exist"));
        System.out.println(name + " " + department);
        if (name != null && name.length() > 0 && !employee.getName().equals(name)) {
            System.out.println(name);
            employee.setName(name);
        }
        if (department != null && department.length() > 0 && !employee.getDepartment().equals(department)) {
            System.out.println(department);
            employee.setDepartment(department);
        }
        employeeRepository.save(employee);
    }
}
