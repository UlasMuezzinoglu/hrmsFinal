package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.JobTitleService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.entities.concretes.JobTitle;

import java.util.List;


@RestController
@RequestMapping("/api/jobTitles/")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        super();
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobTitle>>> getAll() {
        var result= this.jobTitleService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody JobTitle jobTitle){
        var result = this.jobTitleService.add(jobTitle);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }


}
