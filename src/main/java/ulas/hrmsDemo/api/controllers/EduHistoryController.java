package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<EduHistory>>> getAll(){
        var result = this.eduHistoryService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody EduHistory eduHistory) {
        var result = this.eduHistoryService.add(eduHistory);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
