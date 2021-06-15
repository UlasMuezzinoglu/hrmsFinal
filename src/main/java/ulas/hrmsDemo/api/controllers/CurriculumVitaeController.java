package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.business.abstracts.CurriculumViateService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.CurriculumViate;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/curriculum/")
public class CurriculumVitaeController {

    private CurriculumViateService curriculumViateService;


    @Autowired
    public CurriculumVitaeController(CurriculumViateService curriculumViateService) {
        this.curriculumViateService = curriculumViateService;
    }


    @GetMapping("/getall")
    public DataResult<List<CurriculumViate>> getAll(){

        return this.curriculumViateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CurriculumViate curriculumViate){
        //this.employerService.register(employer);
        //return new SuccessResult(employer.getEmail());
        return this.curriculumViateService.add(curriculumViate);
    }

    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int cvId) {
        return this.curriculumViateService.saveImage(file, cvId);
    }

    @GetMapping("/getById")
    public DataResult<List<CurriculumViate>> getbyId(@RequestParam int id){
        return this.curriculumViateService.getByCandidateId(id);
    }


}
