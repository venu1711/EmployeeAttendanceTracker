package service;

import model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    }private Map<Integer, Employee> employeeMap = new HashMap<>();
    public int addEmployee(String name, String department) {
        int id = employeeMap.size() + 1; // Simple ID generation
        Employee newEmployee = new Employee(id, name, department);
        employeeMap.put(id, newEmployee);
        return id;
    }

    public boolean removeEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            return true;
        }
        return false;
    }
}
