package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.SchoolGrade;
import ulas.hrmsDemo.entities.concretes.Talent;

import java.util.List;

public interface TalentDao extends JpaRepository<Talent,Integer> {

}
