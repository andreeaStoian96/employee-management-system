package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.andreeastoian.Employeemanagementsystem.listImpl.util.InitialEmployees.getInitialEmployees;
import static com.andreeastoian.Employeemanagementsystem.util.Messages.showAlterEmployeeMessage;
import static com.andreeastoian.Employeemanagementsystem.util.Messages.showFiltersMessage;

@Component
public class CmdOperationsImpl implements CmdOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(CmdOperationsImpl.class);
    EmployeeCrudOperationsImpl employeeCrudOperationsImpl = new EmployeeCrudOperationsImpl();

    EmployeeFilterOperationsImpl employeeFilterOperationsImpl = new EmployeeFilterOperationsImpl();
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee alterEmployeeFromCmd() {
        employeeList.addAll(getInitialEmployees());
        employeeCrudOperationsImpl.addEmployee(employeeList, employeeFromCmd);
        LOGGER.info("Enter the employee email you want to modify:");
        Scanner input = new Scanner(System.in);
        String verEmail = input.next();
        Employee oldEmp = employeeCrudOperationsImpl.getEmployeeByEmail(employeeList, verEmail);
        showAlterEmployeeMessage();
        int change = input.nextInt();
        switch (change) {
            case 1:
                LOGGER.info("Enter new first name for the employee:");
                oldEmp.setFirstName(input.next());
                break;
            case 2:
                LOGGER.info("Enter new last name for employee:");
                oldEmp.setLastName(input.next());
                break;
            case 3:
                LOGGER.info("Enter the age of the employee:");
                oldEmp.setAge(input.nextInt());
                break;
            case 4:
                String email;
                do {
                    LOGGER.info("Enter the new email address for the employee:");
                    email = input.next();
                    if (isEmailInTheList(email)) {
                        LOGGER.info("This email already exists!");
                        oldEmp.setEmail(input.nextLine());
                    }
                } while (isEmailInTheList(email));
                break;
            case 5:
                LOGGER.info("Enter the new function of the employee:");
                oldEmp.setFunction(input.next());
                break;
            case 6:
                LOGGER.info("Has the employee became a manager? y/n ");
                oldEmp.setManager(input.next().equalsIgnoreCase("y"));
                break;
            case 7:
                LOGGER.info("Enter new manager name:");
                oldEmp.setManagerName(input.next());
                break;
            case 8:
                LOGGER.info("Enter the new salary for employee:");
                oldEmp.setSalary(input.nextDouble());
                break;
            case 9:
                LOGGER.info("Enter employee resign date using the following pattern: yyyy-mm-dd");
                oldEmp.setEmployeeResignDate(LocalDate.parse(input.next()));
                break;
            default:
                LOGGER.info("Enter a correct choice from the list!");
                break;
        }
        employeeCrudOperationsImpl.alterEmployeeFromCmd(employeeList, oldEmp);
        return oldEmp;
    }

    @Override
    public void applyFilters() {
        Scanner input = new Scanner(System.in);
        do {
            showFiltersMessage();
            int filter = input.nextInt();
            switch (filter) {
                case 1:
                    List<Employee> employees = employeeFilterOperationsImpl.getFirstTenEmployeesWithSeniority(employeeList);
                    employees.forEach(System.out::println);
                    break;
                case 2:
                    List<Employee> employeesTwo = employeeFilterOperationsImpl.getFirstFiveEmployeeWithTheBestSalary(employeeList);
                    employeesTwo.forEach(System.out::println);
                    break;
                case 3:
                    LOGGER.info("Enter year as integer!");
                    int year = input.nextInt();
                    LOGGER.info("Enter month as integer!");
                    int month = input.nextInt();
                    List<Employee> employeesThree = employeeFilterOperationsImpl.getEmployeesWhoResignByMonthAndYear(employeeList, month, year);
                    employeesThree.forEach(System.out::println);
                    break;
                case 4:
                    LOGGER.info("Enter how many months!");
                    int months = input.nextInt();
                    List<Employee> filteredEmployees = employeeFilterOperationsImpl.getListOfEmployeesInTheLastXMonths(employeeList, months);
                    filteredEmployees.forEach(System.out::println);
                    break;
                case 5:
                    Optional<Employee> filterFive = employeeFilterOperationsImpl.getEmployeeWithMaximumSalary(employeeList);
                    LOGGER.info(String.valueOf(filterFive));
                    break;
                case 6:
                    Optional<Employee> filterSix = employeeFilterOperationsImpl.getEmployeeWithMinimumSalary(employeeList);
                    LOGGER.info(String.valueOf(filterSix));
                    break;
                case 7:
                    List<Employee> getManagers = employeeFilterOperationsImpl.getManagers(employeeList);
                    LOGGER.info("The managers are: ");
                    for (Employee managers: getManagers)
                        System.out.println(managers);

                    break;
                case 8:
                    employeeFilterOperationsImpl.getManagersAndEmployees(employeeList);
                    break;
                case 9:
                    employeeFilterOperationsImpl.getFunctionAndEmployees(employeeList);
                    break;
                default:
                    LOGGER.info("Enter a valid choice from the list!");
                    break;
            }
        } while (input.nextInt() != 10);
    }
    Employee employeeFromCmd = new Employee();
    @Override
    public Employee createEmployeeFromCmd() {

        Scanner input = new Scanner(System.in);

        LOGGER.info("Enter employee first name: ");
        employeeFromCmd.setFirstName(input.next());
        LOGGER.info("Enter employee last name: ");
        employeeFromCmd.setLastName(input.next());
        LOGGER.info("Enter employee age: ");
        employeeFromCmd.setAge(input.nextInt());
        String email;
        do {
            LOGGER.info("Enter employee email:");
            email = input.next();
            if (isEmailInTheList(email)) {
                LOGGER.info("This email already exists!");
                employeeFromCmd.setEmail(input.nextLine());
            }
        } while (isEmailInTheList(email));
        employeeFromCmd.setEmail(email);

        LOGGER.info("Enter employment date of employee using the following pattern: yyyy-mm-dd");
        employeeFromCmd.setEmploymentDate(LocalDate.parse(input.next()));
        LOGGER.info("Enter employee function:");
        employeeFromCmd.setFunction(input.next());
        LOGGER.info("Is the employee manager? y/n");
        employeeFromCmd.setManager(input.next().equalsIgnoreCase("y"));
        if (employeeFromCmd.isManager()) {
            LOGGER.info("This employee is a manager!");
        } else {
            LOGGER.info("Enter manager name:");
            employeeFromCmd.setManagerName(input.next());
        }
        LOGGER.info("Enter employee salary:");
        employeeFromCmd.setSalary(input.nextDouble());

        return employeeFromCmd;
    }

    public boolean isEmailInTheList(String email) {
        return employeeList.stream()
                .anyMatch(empl -> empl.getEmail().equalsIgnoreCase(email));
    }
}
