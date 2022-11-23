package com.andreeastoian.Employeemanagementsystem.listImpl.operation;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;

public interface CmdOperations {
    Employee alterEmployeeFromCmd();

    void applyFilters();

    Employee createEmployeeFromCmd();

    boolean isEmailInTheList(String email);
}
