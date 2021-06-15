package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.JobTitleService;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.dataAccess.abstracts.JobTitleDao;
import ulas.hrmsDemo.entities.concretes.JobTitle;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        super();
        this.jobTitleDao = jobTitleDao;

    }


    @Override
    public DataResult<List<JobTitle>> getAll() {

        return new SuccessDataResult<>(this.jobTitleDao.findAll(), "Veriler Getirildi - Job Title");
    }


    @Override
    public Result add(JobTitle jobTitle) {

        /*if(isExistJobTitle(jobTitle.getJobTitle()) == true)
        {
            return new ErrorResult("Tekrar Eden Kayıt ! ");
        }*/
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Başarı ile Eklendi - JobTitle");
    }

    public boolean isExistJobTitle(String  alan) {
        for (int i = 0; i < getAll().getData().size(); i++) {
            if (getAll().getData().get(i).getJobTitle() == alan){
                return false;
            }
        }
        return true;
    }

    /*public void isExistJobTitle(String alan) {
        for (int i = 0; i < getAll().getData().size(); i++) {
            if (getAll().getData().get(i).getJobTitle() == alan) {

            }

        }


    }*/
}
