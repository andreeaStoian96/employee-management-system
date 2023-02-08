package com.andreeastoian.Employeemanagementsystem;

import com.andreeastoian.Employeemanagementsystem.h2Impl.service.Application;
import com.andreeastoian.Employeemanagementsystem.listImpl.MainClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories
public class EmployeeManagementSystemWebAppApplication {
    private static Application application;

    @Autowired
    public void EmployeeManagementSystemWebAppApplication(Application application) {
        this.application = application;
    }

    public static void main(String[] args) {
        final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementSystemWebAppApplication.class);

        MainClass javaApplicationImplementation = new MainClass();

        SpringApplication.run(EmployeeManagementSystemWebAppApplication.class, args);

        LOGGER.info("Welcome to Employee Management System! Please chose a method to manage the application" +
                "\n 1.Using Collections\n 2.Using H2");
        Scanner input = new Scanner(System.in);
        int methodOfManagement = input.nextInt();
        if (methodOfManagement == 1) {
            javaApplicationImplementation.mainOperationsForCollectionStorage();
        } else {
            application.mainOperationsForH2Management();
        }
    }
}