package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;

import java.util.List;

public interface CmdOperations {
    Employee alterEmployeeFromCmd(List<Employee> employeeList);
    void applyFilters(List<Employee> employeeList);
    Employee createEmployeeFromCmd(List<Employee> employeeList);
    boolean isEmailInTheList(List<Employee> employeeList,String email);
}
