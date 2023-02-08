package com.andreeastoian.Employeemanagementsystem.h2Impl.service;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;

public interface EmployeeCrudH2Service {
    Employee saveEmployee(Employee employee);
    Employee getEmployee(String email);
    void deleteEmployee(String email);
    void updateEmployee(String email, Employee employee);
}
