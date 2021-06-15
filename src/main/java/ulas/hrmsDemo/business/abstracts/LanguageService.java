package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    Result add(Language language);
    DataResult<List<Language>> getAll();
}
