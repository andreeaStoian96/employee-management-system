package com.andreeastoian.Employeemanagementsystem.listImpl.util;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InitialEmployees {
    public static List<Employee> getInitialEmployees() {
        Employee emp1 = new Employee(1, "Maria", "Ion", 29, "mariaion@yahoo.com",
                LocalDate.of(2009, 12, 11), null, "developer", true, "Maria Ion", 5999.0);
        Employee emp2 = new Employee(2, "Mioara", "Ian", 39, "mioaraian@gmail.com",
                LocalDate.parse("2009-12-23"), LocalDate.parse("2010-02-12"), "HR", false, "Maria Ion", 2599.0);
        Employee emp3 = new Employee(3, "Alex", "Maghe", 40, "alexmaghe@gmail.com",
                LocalDate.parse("2010-11-13"), null, "developer", false, "Maria Ion", 3999.0);
        Employee emp4 = new Employee(4, "Alina", "Vagner", 30, "alinavagner@yahoo.com",
                LocalDate.parse("2017-12-12"), null, "developer", false, "Maria Ion", 2299.0);
        Employee emp5 = new Employee(5, "Marian", "Stenea", 59, "marianstenea@yahoo.com",
                LocalDate.parse("2010-12-11"), null, "developer", true, "Marian Stenea", 5999.0);
        Employee emp6 = new Employee(6, "Ionut", "Alunu", 29, "ionutalunu@yahoo.com",
                LocalDate.parse("2020-10-15"), null, "developer", false, "Marian Stenea", 3999.0);
        Employee emp7 = new Employee(7, "Alin", "Aba", 49, "alinaba@yahoo.com",
                LocalDate.parse("2016-10-16"), null, "developer", false, "Marian Stenea", 3999.0);
        Employee emp8 = new Employee(8, "Adina", "Simo", 25, "adinasimo@yahoo.com",
                LocalDate.parse("2020-11-24"), null, "developer", false, "Maria Ion", 2000.0);
        Employee emp9 = new Employee(9, "Andrei", "Mihai", 43, "andreimihai@yahoo.com",
                LocalDate.parse("2020-12-29"), null, "developer", false, "Maria Ion", 2533.0);
        Employee emp10 = new Employee(10, "Diana", "Posa", 34, "dianaposa@yahoo.com",
                LocalDate.parse("2022-09-02"), null, "developer", false, "Maria Ion", 3525.0);
        Employee emp11 = new Employee(11, "Vlad", "Vasile", 32, "vladvasile@yahoo.com",
                LocalDate.parse("2016-06-03"), null, "developer", false, "Marian Stenea", 3423.0);
        return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, emp11);
    }
}
