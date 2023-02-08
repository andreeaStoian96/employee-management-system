package com.andreeastoian.Employeemanagementsystem.h2Impl.service;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeFilterH2Service {
    List<Employee> getFirstTenEmployeesWithSeniority();
    List<Employee> getFirstFiveEmployeeWithTheBestSalaryH2();
    List<Employee> getEmployeesWhoResignByMonthAndYear( Integer month, Integer year);
    List<Employee> getListOfEmployeesEmployedInTheLastXMonths(Integer months);
    Employee getEmployeeWithMaximumSalary();
    Employee getEmployeeWithMinimumSalary();
    List<Employee> getManagers();
    void getManagersAndEmployees();
    void getFunctionAndEmployees();
}
