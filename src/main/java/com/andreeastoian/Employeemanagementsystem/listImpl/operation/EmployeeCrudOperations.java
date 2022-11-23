package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;

import java.util.List;

public interface EmployeeCrudOperations {

    void addEmployee(List<Employee> employeeList, Employee employee);

    Employee getEmployee(List<Employee> employeeList, String email);

    void deleteEmployee(List<Employee> employeeList, String email);

    void alterEmployeeFromCmd(List<Employee> employeeList, Employee newEmployee);
}
