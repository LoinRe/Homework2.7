package Homework27.Map;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Задание 1 - Map
    Map<String, Employee> employees = new HashMap<>(Map.of(
            new Employee("Ivan", "Svetlov").getFullName(), new Employee("Ivan", "Svetlov"),
            new Employee("Igor", "Ivanov").getFullName(), new Employee("Igor", "Ivanov"),
            new Employee("Olga", "Akimova").getFullName(), new Employee("Olga", "Akimova"),
            new Employee("Sveta", "Molchanova").getFullName(), new Employee("Sveta", "Molchanova")

    ));
    //константа макс кол-во сотрудников
    private static final int maxNumOfEmployees = 5;

    //Метод - добавить сотрудника
    //Задание 1
    @Override
    public String addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);  //создаем сотрудника
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
//            return "Вы пытаетесь добавить сотрудника, который уже добавлен";
        } else {
            employees.put(employee.getFullName(), employee);  //закидываем его в коллекцию
            return "Сотрудник " + name + " " + surname + " добавлен в список. Общее кол-во: " + employees.size();
        }
    }


    //Метод - удалить сотрудника
    //Задание 1
    @Override
    public String deleteEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            //return employees.remove(employee.getFullName());
            return "Сотрудник " + name + " " + surname + " удален из списка";
        }
            throw new EmployeeNotFoundException();
    }


    //Метод - найти сотрудника
    //Задание 1
    @Override
    public String findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.containsKey(employee.getFullName())) {
            return "Сотрудник найден: " + employee.getFullName(); // Возвращаем строковое представление сотрудника
            }
        throw new EmployeeNotFoundException();
    }

    //Метод - вывод в браузер всех сотрудников
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values()); // Возвращаем список всех сотрудников
    }
}
