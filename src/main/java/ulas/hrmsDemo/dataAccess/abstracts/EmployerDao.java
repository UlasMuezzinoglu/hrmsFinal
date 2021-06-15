package ulas.hrmsDemo.dataAccess.abstracts;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
