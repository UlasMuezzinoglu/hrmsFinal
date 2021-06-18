package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.business.abstracts.CurriculumViateService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.City;
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
    public ResponseEntity<DataResult<List<CurriculumViate>>> getAll(){

        var result = this.curriculumViateService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CurriculumViate curriculumViate){
        //this.employerService.register(employer);
        //return new SuccessResult(employer.getEmail());
        var result = this.curriculumViateService.add(curriculumViate);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int cvId) {
        return this.curriculumViateService.saveImage(file, cvId);
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<DataResult<List<CurriculumViate>>> getbyId(@RequestParam int candidateId){
        var result = this.curriculumViateService.getByCandidateId(candidateId);
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }


}
