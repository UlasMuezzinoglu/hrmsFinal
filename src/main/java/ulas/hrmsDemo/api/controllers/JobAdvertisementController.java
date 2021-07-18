package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.business.abstracts.JobAdvertisementService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.JobAdvertisement;
import ulas.hrmsDemo.entities.dtos.JobAdvertisementDto;

import java.util.List;

@RestController
@RequestMapping("api/JobAdvertisement/")
@CrossOrigin
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("getAll")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getAll() {
        var result = this.jobAdvertisementService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getByJobAdvertisementId")
    public ResponseEntity<DataResult<JobAdvertisement>> getByJobAdvertisementId(@RequestParam int id) {
        var result = this.jobAdvertisementService.getByJobAdvertisementId(id);
        if (!(result.getData().isStatus())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getJobs")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getJobs() {
        var result = this.jobAdvertisementService.getAllStatusTrue();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getByEmpId")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getir(int employer_id) {
        var result = this.jobAdvertisementService.findAllByEmployer_IdAndStatusTrue(employer_id);
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestBody JobAdvertisement jobAdvertisement){
        var result = this.jobAdvertisementService.add(jobAdvertisement);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("update")
    public ResponseEntity<Result> update(@RequestParam int jobId, @RequestParam boolean status){
        var result = this.jobAdvertisementService.findById(jobId,status);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @GetMapping("getDataBySortedAsc")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getDataBySortedAsc(){
        var result= this.jobAdvertisementService.findAllByStatusTrueSortedAsc();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getDataBySortedDesc")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getDataBySortedDesc(){
        var result = this.jobAdvertisementService.findAllByStatusTrueOrderByPublishDateDesc();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getJobAdvertisementWithEmpDetails")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getDataWithDetails(){
        var result = this.jobAdvertisementService.getJobAdvertisementWithEmpDetails();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("orderByDate")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getDataOrderByDate(){
        var result= this.jobAdvertisementService.getJobAdvertisementWithEmpDetailsSıralamaAsc();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getirTest")
    public ResponseEntity<DataResult<List<JobAdvertisementDto>>> getDataWithEmpId(@RequestParam int employerId){
        var result = this.jobAdvertisementService.getJobAdvertisementWithEmpDetailsByEmpId(employerId);
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/uploadImage")
    public ResponseEntity<Result> saveImage(@RequestBody MultipartFile file, @RequestParam int jobAdvertisementId) {
        var result = this.jobAdvertisementService.saveImage(file, jobAdvertisementId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
