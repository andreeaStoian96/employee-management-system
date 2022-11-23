package com.andreeastoian.Employeemanagementsystem.controller;

import com.andreeastoian.Employeemanagementsystem.Entity.Employee;
import com.andreeastoian.Employeemanagementsystem.listImpl.operation.EmployeeFilterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeFilterOperations employeeService;

    @Autowired
    EmployeeController(EmployeeFilterOperations employeeService){
        this.employeeService=employeeService;
    }

  /*  @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployyes", employeeService.getAllEmployee());
        return "index";
    }*/
    @RequestMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

}
