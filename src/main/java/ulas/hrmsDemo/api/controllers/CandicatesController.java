package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.CandicateService;
import ulas.hrmsDemo.core.utilities.results.DataResult;

import ulas.hrmsDemo.core.utilities.results.ErrorDataResult;

import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.Employer;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/Candicates/")
@CrossOrigin
public class CandicatesController {

    private CandicateService candicateService;

    @Autowired
    public CandicatesController(CandicateService candicateService) {
        super();
        this.candicateService = candicateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Candicate>>>  getAll(){

        var result = this.candicateService.getAll();
        if (result.getData().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("/add")

    public ResponseEntity<Result> add(@Valid @RequestBody Candicate candicate){

        var result = this.candicateService.register(candicate);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors())
        {
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
        return errors;

    }





}

