package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.LanguageService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.LanguageDao;
import ulas.hrmsDemo.entities.concretes.Language;

import java.time.LocalDate;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao){
        this.languageDao=languageDao;
    }


    @Override
    public Result add(Language language) {
        language.setCreatedDate(LocalDate.now());
        this.languageDao.save(language);
        return new SuccessResult("Başarı İle Eklendi");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"Başarı İle Listelendi - Languages");
    }
}
