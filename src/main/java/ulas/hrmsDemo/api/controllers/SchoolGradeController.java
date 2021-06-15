package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public DataResult<List<SchoolGrade>> getAll(){
        return this.schoolGradeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody SchoolGrade schoolGrade){
        return this.schoolGradeService.add(schoolGrade);

    }
}
