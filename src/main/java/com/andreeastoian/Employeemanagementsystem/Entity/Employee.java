package com.andreeastoian.Employeemanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private LocalDate employmentDate;
    private LocalDate employeeResignDate;
    private String function;
    private boolean isManager;
    private String managerName;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, int age, String email, LocalDate employmentDate, LocalDate employeeResignDate, String function, boolean isManager, String managerName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.employmentDate = employmentDate;
        this.employeeResignDate = employeeResignDate;
        this.function = function;
        this.isManager = isManager;
        this.managerName = managerName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getEmployeeResignDate() {
        return employeeResignDate;
    }

    public void setEmployeeResignDate(LocalDate employeeResignDate) {
        this.employeeResignDate = employeeResignDate;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", employmentDate=" + employmentDate +
                ", employeeResignDate=" + employeeResignDate +
                ", function='" + function + '\'' +
                ", isManager=" + isManager +
                ", managerName='" + managerName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
