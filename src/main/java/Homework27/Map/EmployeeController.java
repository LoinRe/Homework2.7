package Homework27.Map;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в список сотрудников";
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.deleteEmployee(name, surname);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/all")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); // Возвращаем список всех сотрудников
    }
}
