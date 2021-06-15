package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.entities.concretes.Employee;
import ulas.hrmsDemo.entities.concretes.Employer;


import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    DataResult<Boolean> confirmEmployer(Employee staffUser, Employer confirmedEmployerUser);

}
