package Homework27.Map;

import java.util.Collection;

public interface EmployeeService {
    String addEmployee(String name, String surname);

    String deleteEmployee(String name, String surname);

    String findEmployee(String name, String surname);

    Collection<Employee> getAllEmployees();
}
