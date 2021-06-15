package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }


}
