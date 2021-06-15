package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.CandicateService;
import ulas.hrmsDemo.business.abstracts.JobTitleService;
import ulas.hrmsDemo.core.utilities.results.DataResult;

import ulas.hrmsDemo.core.utilities.results.ErrorDataResult;

import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.JobTitle;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;


@RestController
@RequestMapping("/api/Candicates/")

public class CandicatesController {

    private CandicateService candicateService;

    @Autowired
    public CandicatesController(CandicateService candicateService) {
        super();
        this.candicateService = candicateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candicate>> getAll() {

        return this.candicateService.getAll();
    }
    @PostMapping("/add")

    public Result add(@Valid @RequestBody Candicate candicate){

        return this.candicateService.register(candicate);
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

