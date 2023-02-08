package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeFilterOperations {

    List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList);

    List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList);

    List<Employee> getEmployeesWhoResignByMonthAndYear(List<Employee> employeeList, Integer month, Integer year);

    List<Employee> getListOfEmployeesInTheLastXMonths(List<Employee> employeeList, Integer months);

    Optional<Employee> getEmployeeWithMaximumSalary(List<Employee> employeeList);

    Optional<Employee> getEmployeeWithMinimumSalary(List<Employee> employeeList);

    List<Employee> getManagers(List<Employee> employeeList);

    void getManagersAndEmployees(List<Employee> employeeList);

    void getFunctionAndEmployees(List<Employee> employeeList);
}
