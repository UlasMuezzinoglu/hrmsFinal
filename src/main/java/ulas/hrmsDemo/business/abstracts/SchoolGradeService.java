package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.SchoolGrade;

import java.util.List;


public interface SchoolGradeService {

    DataResult<List<SchoolGrade>> getAll();

    Result add(SchoolGrade schoolGrade);


}
