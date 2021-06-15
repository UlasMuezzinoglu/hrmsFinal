package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.EmployeeService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/Employee/")
public class EmployeeController {

    private EmployeeService employeeService;

     @Autowired
    public EmployeeController(EmployeeService employeeService){
         this.employeeService = employeeService;
     }

     @GetMapping("/getall")
     public DataResult<List<Employee>> getAll() {

         return this.employeeService.getAll();
     }



}
