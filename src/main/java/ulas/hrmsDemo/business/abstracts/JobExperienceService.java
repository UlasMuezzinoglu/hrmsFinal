package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    Result add(JobExperience jobExperience);
    DataResult<List<JobExperience>> getAll();
}
