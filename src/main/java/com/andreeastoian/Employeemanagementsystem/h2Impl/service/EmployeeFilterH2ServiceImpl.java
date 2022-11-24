package com.andreeastoian.Employeemanagementsystem.h2Impl.service;


import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import com.andreeastoian.Employeemanagementsystem.h2Impl.repository.EmployeeRepository;
import com.andreeastoian.Employeemanagementsystem.listImpl.operation.EmployeeFilterOperationsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class EmployeeFilterH2ServiceImpl implements EmployeeFilterH2Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFilterH2ServiceImpl.class);
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

    @Override
    public List<Employee> getListOfEmployeesEmployedInTheLastXMonths(Integer months) {
        return employeeRepository.findByOrderByEmploymentDateAsc().stream()
                .filter(employee -> employee.getEmploymentDate().isAfter(LocalDate.now().minusMonths(months)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeWithMaximumSalary() {
        return employeeRepository.findByOrderBySalaryDesc();
    }

    @Override
    public List<Employee> getEmployeeWithMinimumSalary() {
        return employeeRepository.findByOrderBySalaryAsc();
    }

    @Override
    public List<Employee> getManagers() {
        return employeeRepository.findByOrderByManagerName().stream()
                .filter(Employee::isManager)
                .collect(Collectors.toList());
    }

    @Override
    public void getManagersAndEmployees() {
        Map<String, List<Employee>> employeeListByManagers = employeeRepository.findByOrderByManagerName().stream()
                .collect(Collectors.groupingBy(Employee::getManagerName));

        Set<Map.Entry<String, List<Employee>>> entrySet = employeeListByManagers.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entrySet) {
            LOGGER.info("Manager is: \n" + " " + entry.getKey() + "   \n" + "  Employees are: ");
            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                LOGGER.info("   " + e.getFirstName() + " " + e.getLastName());
            }
            LOGGER.info("\n");
        }
    }

    @Override
    public void getFunctionAndEmployees() {
        Map<String, List<Employee>> employeeListByFunction = employeeRepository.findByOrderByFunction().stream()
                .collect(Collectors.groupingBy(Employee::getFunction));
        Set<Map.Entry<String, List<Employee>>> entrySet = employeeListByFunction.entrySet();
        for(Map.Entry<String, List<Employee>> entry : entrySet){
            LOGGER.info("Function is: \n" + entry.getKey() + "\n "+ "Employee name: ");
            List<Employee> list = entry.getValue();
            for(Employee emp : list){
                LOGGER.info(emp.getFirstName() + " " + emp.getFirstName());
            }
            LOGGER.info("\n");
        }
    }

}
