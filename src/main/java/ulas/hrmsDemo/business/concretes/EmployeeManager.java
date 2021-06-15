package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EmployeeService;

import ulas.hrmsDemo.business.checkHelper.concretes.EmployeeCheckHelper;


import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.dataAccess.abstracts.EmployeeDao;
import ulas.hrmsDemo.entities.concretes.Employee;
import ulas.hrmsDemo.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }


    @Override
    public DataResult<List<Employee>> getAll() {

        return new SuccessDataResult<>(this.employeeDao.findAll(),"Veriler Getirildi - Employee");
    }

    @Override
    public DataResult<Boolean> confirmEmployer(Employee staffUser, Employer confirmedEmployerUser) {
        return new SuccessDataResult<>(EmployeeCheckHelper.isConfirmed(confirmedEmployerUser));
    }


}
