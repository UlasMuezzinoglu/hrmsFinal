package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.EduHistoryService;
import ulas.hrmsDemo.business.concretes.EduHistoryManager;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.EduHistory;
import ulas.hrmsDemo.entities.concretes.Talent;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/eduHistory")
public class EduHistoryController {

    private EduHistoryService eduHistoryService;

    @Autowired
    public EduHistoryController(EduHistoryService eduHistoryService){
        this.eduHistoryService = eduHistoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<EduHistory>> getAll(){
        return this.eduHistoryService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody EduHistory eduHistory) {
        return this.eduHistoryService.add(eduHistory);
    }
}
