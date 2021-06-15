package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.JobTitle;

import java.time.LocalDate;
import java.util.List;

public interface CandicateService {
    DataResult<List<Candicate>> getAll();
    Result register(Candicate candicate);


    //DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear);

//    DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear);

}
