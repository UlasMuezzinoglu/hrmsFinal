package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.SchoolGrade;

import java.util.List;

public interface SchoolGradeDao extends JpaRepository<SchoolGrade,Integer> {
    List<SchoolGrade> findAll();
}
