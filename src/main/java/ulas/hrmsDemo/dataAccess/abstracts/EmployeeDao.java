package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
