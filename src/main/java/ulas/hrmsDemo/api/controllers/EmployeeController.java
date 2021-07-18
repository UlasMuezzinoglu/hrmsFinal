package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.EmployeeService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
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
     public ResponseEntity<DataResult<List<Employee>>> getAll() {

         var result = this.employeeService.getAll();
         if (result.getData().size() == 0){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
         }
         return ResponseEntity.ok(result);
     }
     @PutMapping("/confirmEmployer")
    public ResponseEntity<Result> confirmEmployer(@RequestParam int employerId, @RequestParam boolean status){
         var result = this.employeeService.confirmEmployer(employerId,status);
         if (result.isSuccess()){
             return ResponseEntity.ok(result);
         }else {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
         }
     }
    @PutMapping("/confirmJobAdvertisements")
    public ResponseEntity<Result> confirmJobAdvertisements(@RequestParam int jobAdvertisementId, @RequestParam boolean status){
        var result = this.employeeService.confirmJobAdvertisement(jobAdvertisementId,status);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }


}
