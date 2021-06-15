package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.JobTitle;

import java.util.List;
import java.util.Optional;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();
    Result add(JobTitle jobTitle);





}
