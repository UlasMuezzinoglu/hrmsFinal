package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulas.hrmsDemo.business.abstracts.CityService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/api/Cities/")
@CrossOrigin
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {

        return this.cityService.getAll();
    }
}
