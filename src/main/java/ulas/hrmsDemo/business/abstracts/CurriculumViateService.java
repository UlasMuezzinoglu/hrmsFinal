package ulas.hrmsDemo.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.CurriculumViate;

import java.util.List;

public interface CurriculumViateService {
    DataResult<List<CurriculumViate>> getAll();

    Result add(CurriculumViate curriculumViate);

    Result saveImage(MultipartFile file, int cvId);

    DataResult<List<CurriculumViate>> getByCandidateId(int id);

}
