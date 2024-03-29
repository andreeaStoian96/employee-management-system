package com.andreeastoian.Employeemanagementsystem.listImpl;

import com.andreeastoian.Employeemanagementsystem.entity.Employee;
import com.andreeastoian.Employeemanagementsystem.listImpl.operation.CmdOperationsImpl;
import com.andreeastoian.Employeemanagementsystem.listImpl.operation.EmployeeCrudOperationsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.andreeastoian.Employeemanagementsystem.listImpl.util.InitialEmployees.getInitialEmployees;
import static com.andreeastoian.Employeemanagementsystem.util.Messages.showMainOperationMessage;


public class MainClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainClass.class);
    private EmployeeCrudOperationsImpl employeeCrudOperationsImpl = new EmployeeCrudOperationsImpl();
    private CmdOperationsImpl cmdOperationsImpl = new CmdOperationsImpl();
    public List<Employee> employeeList = new ArrayList<>();

    public void mainOperationsForCollectionStorage() {
        employeeList.addAll(getInitialEmployees());
        Scanner input = new Scanner(System.in);
        do {
            showMainOperationMessage();
            int inp = input.nextInt();
            switch (inp) {
                case 1:
                    employeeCrudOperationsImpl.addEmployee(employeeList, cmdOperationsImpl.createEmployeeFromCmd(employeeList));
                    LOGGER.info("Employee added!");
                    break;
                case 2:
                    LOGGER.info("Enter the email for the person you want to search:\n");
                    String verEmail = input.next();
                    employeeCrudOperationsImpl.getEmployee(employeeList, verEmail);
                    break;
                case 3:
                    LOGGER.info("All the employees:\n");
                    employeeCrudOperationsImpl.showAllEmployees(employeeList);
                    break;
                case 4:
                    LOGGER.info("Enter the email of the person you want to delete!");
                    verEmail = input.next();
                    employeeCrudOperationsImpl.deleteEmployee(employeeList, verEmail);
                    break;
                case 5:
                    cmdOperationsImpl.alterEmployeeFromCmd(employeeList);
                    break;
                case 6:
                    cmdOperationsImpl.applyFilters(employeeList);
                    break;
                case 7:
                    LOGGER.info("You have choose to exit!");
                    break;
                default:
                    LOGGER.info("Enter a valid choice!");
            }
        } while (input.nextInt() != 7);
    }
}

