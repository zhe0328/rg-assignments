import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/rg_temp";
    private static final String USER = "rg_user";
    private static final String PASSWORD = "password123";

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDepartment());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read all
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                Employee employee = new Employee(id, name, department);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Read by ID
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String department = resultSet.getString("department");
                    employee = new Employee(id, name, department);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    // Update
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setInt(3, employee.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Creating employees
        Employee e1 = new Employee(1, "Alice", "HR");
        Employee e2 = new Employee(2, "Bob", "Engineering");
        Employee e3 = new Employee(3, "Charlie", "Sales");

        // Adding employees
        employeeJDBC.addEmployee(e1);
        employeeJDBC.addEmployee(e2);
        employeeJDBC.addEmployee(e3);

        System.out.println("All Employees: ");
        for (Employee employee : employeeJDBC.getAllEmployees()) {
            System.out.println(employee.toString());
        }

        Employee employee = employeeJDBC.getEmployeeById(2);
        System.out.println("Employee with ID 2: " + employee);

        Employee updatedEmployee = new Employee(2, "Bob", "Marketing");
        employeeJDBC.updateEmployee(updatedEmployee);
        System.out.println("Updated Employee with ID 2: " + employeeJDBC.getEmployeeById(2));

        employeeJDBC.deleteEmployee(3);
        System.out.println("All Employees after deletion: ");
        for (Employee curEmployee : employeeJDBC.getAllEmployees()) {
            System.out.println(curEmployee.toString());
        }
    }
}
