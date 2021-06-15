package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.User;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result register(Employer employer);


}
