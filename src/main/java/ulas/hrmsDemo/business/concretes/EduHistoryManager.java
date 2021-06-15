package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EduHistoryService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.EduHistoryDao;
import ulas.hrmsDemo.entities.concretes.EduHistory;

import java.time.LocalDate;
import java.util.List;

@Service
public class EduHistoryManager implements EduHistoryService {

    private EduHistoryDao eduHistoryDao;

    @Autowired
    public EduHistoryManager(EduHistoryDao eduHistoryDao){
        this.eduHistoryDao = eduHistoryDao;
    }


    @Override
    public Result add(EduHistory eduHistory) {
        eduHistory.setCreatedDate(LocalDate.now());
        this.eduHistoryDao.save(eduHistory);
        return new SuccessResult("Başarı İle Eklendi");
    }

    @Override
    public DataResult<List<EduHistory>> getAll() {
        return new SuccessDataResult<List<EduHistory>>(this.eduHistoryDao.findAll(),"Başarı ile Getirildi - EduHistory");
    }
}
