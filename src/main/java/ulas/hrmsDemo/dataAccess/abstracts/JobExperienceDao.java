package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
}
