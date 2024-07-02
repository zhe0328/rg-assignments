import java.util.ArrayList;
import java.util.List;

class EmployeeCRUD {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId() == updatedEmployee.getId()) {
                employeeList.set(i, updatedEmployee);
                System.out.println("Employee updated: " + updatedEmployee);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                Employee removedEmployee = employeeList.remove(i);
                System.out.println("Employee removed: " + removedEmployee);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        Employee e1 = new Employee(1, "Alice", "HR");
        Employee e2 = new Employee(2, "Bob", "Engineering");
        Employee e3 = new Employee(3, "Charlie", "Sales");

        employeeCRUD.addEmployee(e1);
        employeeCRUD.addEmployee(e2);
        employeeCRUD.addEmployee(e3);

        System.out.println("All Employees: ");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee.toString());
        }

        System.out.println("Employee with ID 2: " + employeeCRUD.getEmployeeById(2));

        Employee updatedEmployee = new Employee(2, "Bob", "Marketing");
        employeeCRUD.updateEmployee(updatedEmployee);
        System.out.println("Updated Employee with ID 2: " + employeeCRUD.getEmployeeById(2));

        employeeCRUD.deleteEmployee(3);
        System.out.println("All Employees after deletion: ");
        for (Employee employee : employeeCRUD.getAllEmployees()) {
            System.out.println(employee.toString());
        }
    }
}