package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
}
