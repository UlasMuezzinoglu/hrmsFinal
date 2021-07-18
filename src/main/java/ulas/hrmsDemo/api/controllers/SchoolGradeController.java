package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.EmployerService;
import ulas.hrmsDemo.business.abstracts.SchoolGradeService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.SchoolGrade;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/SchoolGrade")
public class SchoolGradeController {


    private SchoolGradeService schoolGradeService;

    @Autowired
    public SchoolGradeController(SchoolGradeService schoolGradeService) {
        this.schoolGradeService = schoolGradeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<SchoolGrade>>> getAll(){
        var result = this.schoolGradeService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody SchoolGrade schoolGrade){
        var result = this.schoolGradeService.add(schoolGrade);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<Result> addMultiple(@RequestBody SchoolGrade[] schoolGrades){
        var result = this.schoolGradeService.addMultiple(schoolGrades);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
