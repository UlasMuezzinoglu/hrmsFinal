package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Talent;

import java.util.List;

public interface TalentService {
    Result add(Talent talent);

    DataResult<List<Talent>> getAll();
}
