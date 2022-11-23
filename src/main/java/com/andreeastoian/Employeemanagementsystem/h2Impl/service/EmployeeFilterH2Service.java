package com.andreeastoian.Employeemanagementsystem.h2Impl.service;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;

import java.util.List;

public interface EmployeeFilterH2Service {
    List<Employee> getFirstTenEmployeesWithSeniority();

   // Optional<List<Employee>> getFirstFiveEmployeeWithTheBestSalary(Employee employee);

    List<Employee> getFirstFiveEmployeeWithTheBestSalaryH2();
}
