package com.andreeastoian.Employeemanagementsystem.h2Impl.service;

import com.andreeastoian.Employeemanagementsystem.h2Impl.operationH2.H2Operations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

import static com.andreeastoian.Employeemanagementsystem.util.Messages.showMainOperationMessage;

@Configuration
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    @Autowired
    H2Operations h2Operations;
    @Autowired
    EmployeeCrudH2ServiceImpl employeeCrudH2Service;
    @Autowired
    EmployeeFilterH2ServiceImpl employeeFilterH2ServiceImpl;

    @Autowired
    public void Application(H2Operations h2Operations) {
        this.h2Operations = h2Operations;
    }


    public void mainMessageH2() {
        Scanner input = new Scanner(System.in);
        do {
            showMainOperationMessage();
            int inp = input.nextInt();
            switch (inp) {
                case 1:
                    employeeCrudH2Service.saveEmployee(h2Operations.createEmployeeForH2());
                    LOGGER.info("Employee added!");
                    break;

                case 2:
                    LOGGER.info("Enter the email for the person you want to search:");
                    String verEmail = input.next();
                    employeeCrudH2Service.getEmployee(verEmail);
                    break;

                case 3:
                    LOGGER.info("Enter the email for the person you want to delete:");
                    verEmail = input.next();
                    employeeCrudH2Service.deleteEmployee(verEmail);
                    LOGGER.info("Employee deleted!");
                    break;

                case 4:
                    h2Operations.alterEmployeeFromH2Database();
                    break;
                case 5:
                    h2Operations.applyFilters();
            }

        } while (input.nextInt() != 6);

    }
}
