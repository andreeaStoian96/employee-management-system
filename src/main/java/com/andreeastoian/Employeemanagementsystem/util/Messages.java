package com.andreeastoian.Employeemanagementsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Messages {
    private static final Logger LOGGER = LoggerFactory.getLogger(Messages.class);

    public static void showMainOperationMessage() {
        LOGGER.info("Press: \n"
                + "1 for add employee\n"
                + "2 for view employee by email\n"
                + "3 for view all employees\n"
                + "4 for delete employee\n"
                + "5 for alter employee\n"
                + "6 for filters\n"
                + "7 for exiting the program");
    }

    public static void showFiltersMessage() {
        LOGGER.info("Choose from the filter:\n"
                + "1.First 10 employees in terms of seniority in the company\n"
                + "2.First 5 employees with the highest salary\n"
                + "3.The employees that have resign in certain year and month\n"
                + "4.List of employees in the last (enter the numbers of months)\n"
                + "5.Employee with the highest salary\n"
                + "6.Employee with the lowest salary\n"
                + "7.Show managers\n"
                + "8.Show managers with they're employee\n"
                + "9.Show function and employee\n"
                + "10.Enter 10 for main menu!");
    }

    public static void showAlterEmployeeMessage() {
        LOGGER.info("What do you want to modify?\n"
                + "1.First name\n"
                + "2.Last name\n"
                + "3.Age\n"
                + "4.Email\n"
                + "5.Function\n"
                + "6.Is employee manager?\n"
                + "7.Manager name\n"
                + "8.Salary\n"
                + "9.resign date");
        LOGGER.info("Enter your choice:");
    }
}
