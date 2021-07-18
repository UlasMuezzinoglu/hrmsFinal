package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.TalentService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Talent;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/talent")
public class TalentController {

    private TalentService talentService;

    @Autowired
    public TalentController(TalentService talentService){
        this.talentService = talentService;
    }
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Talent>>> getAll(){
        var result = this.talentService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody Talent talent) {
        var result = this.talentService.add(talent);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
