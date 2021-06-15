package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public DataResult<List<Talent>> getAll(){
        return this.talentService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody Talent talent) {
        return this.talentService.add(talent);
    }
}
