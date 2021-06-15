package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.EduHistory;

import java.util.List;

public interface EduHistoryService {
    Result add(EduHistory eduHistory);
    DataResult<List<EduHistory>> getAll();
}
