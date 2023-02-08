package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.andreeastoian.Employeemanagementsystem.listImpl.util.InitialEmployees.getInitialEmployees;

@Service
public class
EmployeeFilterOperationsImpl implements EmployeeFilterOperations {
    List<Employee> employeeList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFilterOperationsImpl.class);

    public  List<Employee> getFirstTenEmployeesWithSeniority(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        return employeeList.stream()
                .limit(10)
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());
    }

    @Override
    public  List<Employee> getFirstFiveEmployeeWithTheBestSalary(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        return  employeeList.stream()
                .limit(5)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public  List<Employee> getEmployeesWhoResignByMonthAndYear(List<Employee> employeeList, Integer month, Integer year) {
        employeeList.addAll(getInitialEmployees());
        List<Employee> employeesWithResignDate = employeeList.stream()
                .filter(employee -> employee.getEmployeeResignDate() != null)
                .collect(Collectors.toList());
        return employeesWithResignDate.stream().filter(employee ->
                        (employee.getEmployeeResignDate().getYear() == year && employee.getEmployeeResignDate().getMonthValue() == month))
                .collect(Collectors.toList());
    }

    @Override
    public  List<Employee> getListOfEmployeesInTheLastXMonths(List<Employee> employeeList, Integer months) {
        employeeList.addAll(getInitialEmployees());
        return employeeList.stream()
                .filter(employee -> employee.getEmploymentDate().isAfter(LocalDate.now().minusMonths(months)))
                .collect(Collectors.toList());
    }

    @Override
    public  Optional<Employee> getEmployeeWithMaximumSalary(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        return employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public  Optional<Employee> getEmployeeWithMinimumSalary(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        return employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public List<Employee> getManagers(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        return employeeList.stream()
                .filter(Employee::isManager)
                .collect(Collectors.toList());
    }

    @Override
    public void getManagersAndEmployees(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        Map<String, List<Employee>> employeeListByManagers = employeeList.stream()
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
    public void getFunctionAndEmployees(List<Employee> employeeList) {
        employeeList.addAll(getInitialEmployees());
        Map<String, List<Employee>> employeeListByFunction = employeeList.stream()
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



