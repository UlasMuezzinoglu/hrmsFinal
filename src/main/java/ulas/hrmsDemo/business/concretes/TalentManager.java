package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.TalentService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.TalentDao;
import ulas.hrmsDemo.entities.concretes.Talent;

import java.time.LocalDate;
import java.util.List;

@Service
public class TalentManager implements TalentService {

    private TalentDao talentDao;

    @Autowired
    public TalentManager(TalentDao talentDao){
        this.talentDao = talentDao;
    }


    @Override
    public Result add(Talent talent) {
        talent.setCreatedDate(LocalDate.now());
        talentDao.save(talent);
        return new SuccessResult("Başarı ile eklendi");
    }

    @Override
    public DataResult<List<Talent>> getAll() {
        return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(),"Başarı İle Getirildi - Talents");
    }

}
