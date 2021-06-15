package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {

}
