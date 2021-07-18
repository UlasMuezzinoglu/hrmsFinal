package ulas.hrmsDemo.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<Language>>> getAll(){
        var result = this.languageService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody Language language) {
        var result = this.languageService.add(language);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
