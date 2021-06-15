package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ulas.hrmsDemo.entities.concretes.CurriculumViate;
import ulas.hrmsDemo.entities.dtos.CvDto;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumViate,Integer> {


    //@Query()

    /*@Query("Select new ulas.hrmsDemo.entities.dtos" +
            "()" +
            "")*/
    @Query("From CurriculumViate where candidate_Id=:id")
    List<CurriculumViate> getByCandicate_Id(int id);




}
