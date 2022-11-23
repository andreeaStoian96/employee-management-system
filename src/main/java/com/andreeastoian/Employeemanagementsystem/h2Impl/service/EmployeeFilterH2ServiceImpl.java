package com.andreeastoian.Employeemanagementsystem.h2Impl.service;


import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import com.andreeastoian.Employeemanagementsystem.h2Impl.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class EmployeeFilterH2ServiceImpl implements EmployeeFilterH2Service {3
    private EmployeeRepository employeeRepository;

    public EmployeeFilterH2ServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getFirstTenEmployeesWithSeniority() {
        List<Employee> employeeList = employeeRepository.findByOrderByEmploymentDateAsc();
        return employeeList;
    }
    @Override
    public List<Employee> getFirstFiveEmployeeWithTheBestSalaryH2() {
        List<Employee> employeeList = employeeRepository.findByOrderBySalaryDesc();
        return employeeList;
    }
}
