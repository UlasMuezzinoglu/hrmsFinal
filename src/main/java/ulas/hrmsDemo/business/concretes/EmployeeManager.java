package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EmployeeService;

import ulas.hrmsDemo.business.checkHelper.concretes.EmployeeCheckHelper;


import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.dataAccess.abstracts.EmployeeDao;
import ulas.hrmsDemo.dataAccess.abstracts.EmployerDao;
import ulas.hrmsDemo.dataAccess.abstracts.JobAdvertisementDao;
import ulas.hrmsDemo.entities.concretes.Employee;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.JobAdvertisement;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmployerDao employerDao;
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao,EmployerDao employerDao,JobAdvertisementDao jobAdvertisementDao){
        this.employeeDao = employeeDao;
        this.employerDao = employerDao;
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public DataResult<List<Employee>> getAll() {

        return new SuccessDataResult<>(this.employeeDao.findAll(),"Veriler Getirildi - Employee");
    }

    @Override
    public Result confirmEmployer(int employerId, boolean status) {
        try {
            Employer employer;
            employer = this.employerDao.getOne(employerId);
            employer.setConfirmed(status);

            this.employerDao.save(employer);
            return new SuccessResult("İşlem Başarılı");

        }catch (Exception e){
            return new ErrorResult("İşlem Başarısız");

        }

    }

    @Override
    public Result confirmJobAdvertisement(int jobAdvertisementId, boolean status) {
        try {
            JobAdvertisement jobAdvertisement;
            jobAdvertisement = this.jobAdvertisementDao.getOne(jobAdvertisementId);
            jobAdvertisement.setConfirmed(status);

            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İşlem Başarılı");

        }catch (Exception e){
            return new ErrorResult("İşlem Başarısız");

        }
    }


}
