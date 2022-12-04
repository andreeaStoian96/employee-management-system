package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import com.andreeastoian.Employeemanagementsystem.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeCrudOperationsImpl implements EmployeeCrudOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCrudOperationsImpl.class);

    @Override
    public void addEmployee(List<Employee> employeeList, Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public Employee getEmployee(List<Employee> employeeList, String verEmail) {
        Employee employee = getEmployeeByEmail(employeeList, verEmail);
        LOGGER.info(employee.toString());
        return employee;
    }

    @Override
    public void deleteEmployee(List<Employee> employeeList, String verEmail) {
        Predicate<Employee> condition = employee -> (employee.getEmail().equals(verEmail));
        employeeList.removeIf(condition);
        LOGGER.info("Employee deleted!");
    }

    @Override
    public void alterEmployeeFromCmd(List<Employee> employeeList, Employee newEmployee) {
        for (Employee oldEmp : employeeList) {
            if (oldEmp.getId() == (newEmployee.getId())) {
                break;
            }
        }
        LOGGER.info(String.valueOf(newEmployee));
    }

    public Employee getEmployeeByEmail(List<Employee> employeeList, String verEmail) {
        List<Employee> employee = employeeList.stream()
                .filter(employee1 -> employee1.getEmail().equalsIgnoreCase(verEmail))
                .collect(Collectors.toList());
        if (!employee.isEmpty()) {
            return employee.get(0);
        }
        throw new EmployeeNotFoundException(String.format("No employee found for email: %s", verEmail));
    }

}
