package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("getByJobAdvertisementId")
    public DataResult<JobAdvertisement> getByJobAdvertisementId(@RequestParam int id){return this.jobAdvertisementService.getByJobAdvertisementId(id);}

    @GetMapping("getJobs")
    public DataResult<List<JobAdvertisement>> getJobs() {
        return this.jobAdvertisementService.getAllStatusTrue();
    }

    @GetMapping("getByEmpId")
    public DataResult<List<JobAdvertisement>> getir(int employer_id) {
        return this.jobAdvertisementService.findAllByEmployer_IdAndStatusTrue(employer_id);
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PutMapping("update")
    public Result update(@RequestParam int jobId, @RequestParam boolean status){
        return this.jobAdvertisementService.findById(jobId,status);
    }

    @GetMapping("getDataBySortedAsc")
    public DataResult<List<JobAdvertisement>> getDataBySortedAsc(){
        return this.jobAdvertisementService.findAllByStatusTrueSortedAsc();
    }

    @GetMapping("getDataBySortedDesc")
    public DataResult<List<JobAdvertisement>> getDataBySortedDesc(){
        return this.jobAdvertisementService.findAllByStatusTrueOrderByPublishDateDesc();
    }

    @GetMapping("getJobAdvertisementWithEmpDetails")
    public DataResult<List<JobAdvertisementDto>> getDataWithDetails(){
        return this.jobAdvertisementService.getJobAdvertisementWithEmpDetails();
    }

    @GetMapping("orderByDate")
    public DataResult<List<JobAdvertisementDto>> getDataOrderByDate(){
        return this.jobAdvertisementService.getJobAdvertisementWithEmpDetailsSıralamaAsc();
    }

    @GetMapping("getirTest")
    public DataResult<List<JobAdvertisementDto>> getDataWithEmpId(@RequestParam int employerId){
        return this.jobAdvertisementService.getJobAdvertisementWithEmpDetailsByEmpId(employerId);
    }

    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int jobAdvertisementId) {
        return this.jobAdvertisementService.saveImage(file, jobAdvertisementId);
    }
}
