package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.JobExperienceService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.JobExperienceDao;
import ulas.hrmsDemo.entities.concretes.JobExperience;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao){
        this.jobExperienceDao = jobExperienceDao;
    }


    @Override
    public Result add(JobExperience jobExperience) {
        jobExperience.setCreatedDate(LocalDate.now());
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Başarı ile Eklendi");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"Başarı İle Getirildi - Jobexperience");
    }
}
