package com.andreeastoian.Employeemanagementsystem.h2Impl.service;


import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import com.andreeastoian.Employeemanagementsystem.h2Impl.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeFilterH2ServiceImpl implements EmployeeFilterH2Service {
    private EmployeeRepository employeeRepository;

    public EmployeeFilterH2ServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getFirstTenEmployeesWithSeniority() {
        return employeeRepository.findByOrderByEmploymentDateAsc();
    }

    @Override
    public List<Employee> getFirstFiveEmployeeWithTheBestSalaryH2() {
        return employeeRepository.findByOrderBySalaryDesc();
    }

    public List<Employee> getEmployeesWhoResignByMonthAndYear(Integer month, Integer year) {
        List<Employee> employeeResigns = employeeRepository.findByOrderByEmployeeResignDate().stream()
                .filter(employee -> employee.getEmployeeResignDate() != null)
                .collect(Collectors.toList());
        return employeeResigns.stream()
                .filter(employee -> employee.getEmployeeResignDate().getYear() == year
                        && employee.getEmployeeResignDate().getMonthValue() == month)
                .collect(Collectors.toList());

    }
}
