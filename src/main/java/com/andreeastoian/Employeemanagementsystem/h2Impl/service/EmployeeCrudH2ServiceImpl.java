package com.andreeastoian.Employeemanagementsystem.h2Impl.service;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import com.andreeastoian.Employeemanagementsystem.exception.EmployeeNotFoundException;
import com.andreeastoian.Employeemanagementsystem.h2Impl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeCrudH2ServiceImpl implements EmployeeCrudH2Service {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployee(String email) {
        return getEmployeeByEmail(email);
    }

    @Override
    public void deleteEmployee(String email) {
        Employee employee = getEmployeeByEmail(email);
        employeeRepository.delete(employee);
    }

    @Override
    public void updateEmployee(String email, Employee employee) {
        Employee oldEmployee = getEmployeeByEmail(email);
        oldEmployee = employee;
        employeeRepository.save(oldEmployee);
    }

    public Employee getEmployeeByEmail(String email) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);
        optionalEmployee.orElseThrow(() -> new EmployeeNotFoundException(String.format("No employee found for email %s", email)));
        return optionalEmployee.get();
    }

}
