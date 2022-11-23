package com.andreeastoian.Employeemanagementsystem.h2Impl.service;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;

import java.util.List;

public interface EmployeeFilterH2Service {
    List<Employee> getFirstTenEmployeesWithSeniority();
    List<Employee> getFirstFiveEmployeeWithTheBestSalaryH2();
    List<Employee> getEmployeesWhoResignByMonthAndYear( Integer month, Integer year);
}
