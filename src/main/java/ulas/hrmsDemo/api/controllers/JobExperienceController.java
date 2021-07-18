package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.JobExperienceService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.JobExperience;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobExperience>>> getAll(){
        var result = this.jobExperienceService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody JobExperience jobExperience) {
        var result = this.jobExperienceService.add(jobExperience);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

}
