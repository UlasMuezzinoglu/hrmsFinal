package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.SchoolGradeService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.SchoolGradeDao;
import ulas.hrmsDemo.entities.concretes.SchoolGrade;

import java.util.List;


@Service
public class SchoolGradeManager implements SchoolGradeService {

    private SchoolGradeDao schoolGradeDao;


    @Autowired
     public SchoolGradeManager(SchoolGradeDao schoolGradeDao){
        this.schoolGradeDao = schoolGradeDao;
    }

    @Override
    public DataResult<List<SchoolGrade>> getAll() {
        return new SuccessDataResult<List<SchoolGrade>>
                (this.schoolGradeDao.findAll(),"Başarı ile Getirildi - School Grades");
    }

    @Override
    public Result add(SchoolGrade schoolGrade) {
        this.schoolGradeDao.save(schoolGrade);
        return new SuccessResult("Başarı ile Eklendi");
    }
}
