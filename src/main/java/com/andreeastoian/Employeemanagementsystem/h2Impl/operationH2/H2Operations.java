package com.andreeastoian.Employeemanagementsystem.h2Impl.operationH2;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;
import com.andreeastoian.Employeemanagementsystem.h2Impl.repository.EmployeeRepository;
import com.andreeastoian.Employeemanagementsystem.h2Impl.service.EmployeeCrudH2ServiceImpl;
import com.andreeastoian.Employeemanagementsystem.h2Impl.service.EmployeeFilterH2ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.andreeastoian.Employeemanagementsystem.util.Messages.showAlterEmployeeMessage;
import static com.andreeastoian.Employeemanagementsystem.util.Messages.showFiltersMessage;

@Component
public class H2Operations {
    private final EmployeeRepository employeeRepository;
    private final EmployeeCrudH2ServiceImpl employeeCrudH2ServiceImpl;
    private final EmployeeFilterH2ServiceImpl employeeFilterH2ServiceImpl;

    public H2Operations(EmployeeRepository employeeRepository, EmployeeCrudH2ServiceImpl employeeCrudH2ServiceImpl, EmployeeFilterH2ServiceImpl employeeFilterH2ServiceImpl) {
        this.employeeRepository = employeeRepository;
        this.employeeCrudH2ServiceImpl = employeeCrudH2ServiceImpl;
        this.employeeFilterH2ServiceImpl = employeeFilterH2ServiceImpl;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(H2Operations.class);

    public Employee createEmployeeForH2() {
        Employee employee = new Employee();
        Scanner input = new Scanner(System.in);
        LOGGER.info("Enter employee first name: ");
        employee.setFirstName(input.next());
        LOGGER.info("Enter employee last name: ");
        employee.setLastName(input.next());
        LOGGER.info("Enter employee age: ");
        employee.setAge(input.nextInt());
        String email;
        boolean emailAlreadyExists;
        do {
            LOGGER.info("Enter employee email:");
            email = input.next();
            emailAlreadyExists = isEmailInTheList(email);
            if (emailAlreadyExists) {
                LOGGER.info("This email already exists!");
            }
        } while (emailAlreadyExists);
        employee.setEmail(email);
        LOGGER.info("Enter employment date of employee using the following pattern: yyyy-mm-dd");
        employee.setEmploymentDate(LocalDate.parse(input.next()));
        LOGGER.info("Enter employee function:");
        employee.setFunction(input.next());
        LOGGER.info("Is the employee manager? y/n");
        employee.setManager(input.next().equalsIgnoreCase("y"));
        if (employee.isManager()) {
            LOGGER.info("This employee is a manager!");
        } else {
            LOGGER.info("Enter manager name:");
            employee.setManagerName(input.next());
        }
        LOGGER.info("Enter employee salary:");
        employee.setSalary(input.nextDouble());
        return employee;
    }

    private boolean isEmailInTheList(String email) {
        return employeeRepository.findEmail(email) != null;
    }

    public void applyFilters() {
        Scanner input = new Scanner(System.in);
        do {
            showFiltersMessage();
            int filter = input.nextInt();
            switch (filter) {
                case 1:
                    List<Employee> employeeListH2 = employeeFilterH2ServiceImpl.getFirstTenEmployeesWithSeniority();
                    for (int i = 0; i <= 9; i++)
                        LOGGER.info(String.valueOf(employeeListH2.get(i)));
                    break;

                case 2:
                    List<Employee> employeeSalaryListH2 = employeeFilterH2ServiceImpl.getFirstFiveEmployeeWithTheBestSalaryH2();
                    for (int i = 0; i <= 4; i++)
                        LOGGER.info(String.valueOf(employeeSalaryListH2.get(i)));
                    break;
                case 3:
                    LOGGER.info("Enter year as integer!");
                    int year = input.nextInt();
                    LOGGER.info("Enter month as integer!");
                    int month = input.nextInt();
                    List<Employee> employeesWhoResign = employeeFilterH2ServiceImpl.getEmployeesWhoResignByMonthAndYear(month, year);
                    System.out.println(employeesWhoResign);
                    break;
                case 4:
                    LOGGER.info("Enter how many months!");
                    int months = input.nextInt();
                    List<Employee> employeesEmployedInTheLastXMonths = employeeFilterH2ServiceImpl.getListOfEmployeesEmployedInTheLastXMonths(months);
                    employeesEmployedInTheLastXMonths.forEach(System.out::println);
                    break;
                case 5:
                    List<Employee> employeeWithTheBiggestSalary = employeeFilterH2ServiceImpl.getEmployeeWithMaximumSalary();
                    LOGGER.info(String.valueOf(employeeWithTheBiggestSalary.get(0)));
                    break;
                case 6:
                    List<Employee> employeeWithSmallestSalary = employeeFilterH2ServiceImpl.getEmployeeWithMinimumSalary();
                    LOGGER.info(String.valueOf(employeeWithSmallestSalary.get(0)));
                    break;
                case 7:
                    List<Employee> managers = employeeFilterH2ServiceImpl.getManagers();
                    LOGGER.info("The managers are: ");
                    managers.forEach(System.out::println);
                    break;
                case 8:
                    employeeFilterH2ServiceImpl.getManagersAndEmployees();
                    break;
                case 9:
                    employeeFilterH2ServiceImpl.getFunctionAndEmployees();
                    break;
                default:
                    LOGGER.info("Enter a valid choice from the list!");
                    break;
            }
        } while (input.nextInt() != 10);
    }

    public  Employee alterEmployeeFromH2Database() {
        LOGGER.info("Enter the employee email you want to modify:");
        Scanner input = new Scanner(System.in);
        String verEmail = input.next();
        Employee oldEmp = employeeCrudH2ServiceImpl.getEmployeeByEmail(verEmail);
        showAlterEmployeeMessage();
        int change = input.nextInt();
        switch (change) {
            case 1:
                LOGGER.info("Enter new first name for the employee:");
                oldEmp.setFirstName(input.next());
                LOGGER.info("First name  changed!");
                break;
            case 2:
                LOGGER.info("Enter new last name for employee:");
                oldEmp.setLastName(input.next());
                LOGGER.info("Last name  changed!");
                break;
            case 3:
                LOGGER.info("Enter the age of the employee:");
                oldEmp.setAge(input.nextInt());
                LOGGER.info("Age changed!");
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
                LOGGER.info("Email changed!");
                break;
            case 5:
                LOGGER.info("Enter the new function of the employee:");
                oldEmp.setFunction(input.next());
                LOGGER.info("Function changed!");
                break;
            case 6:
                LOGGER.info("Has the employee became a manager? y/n ");
                oldEmp.setManager(input.next().equalsIgnoreCase("y"));
                LOGGER.info("Status of employee changed!");
                break;
            case 7:
                LOGGER.info("Enter new manager name:");
                oldEmp.setManagerName(input.next());
                LOGGER.info("Manager name changed!");
                break;
            case 8:
                LOGGER.info("Enter the new salary for employee:");
                oldEmp.setSalary(input.nextDouble());
                LOGGER.info("Salary changed!");
                break;
            case 9:
                LOGGER.info("Enter employee resign date using the following pattern: yyyy-mm-dd");
                oldEmp.setEmployeeResignDate(LocalDate.parse(input.next()));
                LOGGER.info("Resign date changed!");
                break;
            default:
                LOGGER.info("Enter a correct choice from the list!");
                break;
        }
        employeeCrudH2ServiceImpl.updateEmployee(verEmail, oldEmp);
       return oldEmp;

    }

}

