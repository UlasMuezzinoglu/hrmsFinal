package ulas.hrmsDemo.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.LanguageService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Language;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }
    @GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody Language talent) {
        return this.languageService.add(talent);
    }
}
