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

        LOGGER.info("Welcome to Employee Management System!\n 1.Use Java application\n 2.Use Java application with h2 database");
        Scanner input = new Scanner(System.in);
        int inp = input.nextInt();
        if (inp == 1) {
            javaApplicationImplementation.mainMassage();
        } else {
            application.mainMessageH2();
        }
    }
}