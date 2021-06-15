package ulas.hrmsDemo.business.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.business.abstracts.CurriculumViateService;
import ulas.hrmsDemo.core.utilities.cloudinary.CloudinaryManager;
import ulas.hrmsDemo.core.utilities.cloudinary.CloudinaryService;
import ulas.hrmsDemo.core.utilities.helpers.CurriculumVitaeHelper;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.dataAccess.abstracts.*;
import ulas.hrmsDemo.entities.concretes.CurriculumViate;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class CurriculumViateManager implements CurriculumViateService {

    private CurriculumVitaeDao curriculumVitaeDao;
    private CloudinaryService cloudinaryService;

    /*private LanguageDao languageDao;
    private TalentDao talentDao;
    private EduHistoryDao eduHistoryDao;
    private JobExperienceDao jobExperienceDao;*/



    @Autowired
    public CurriculumViateManager(CurriculumVitaeDao curriculumVitaeDao,CloudinaryService cloudinaryService) {
        this.curriculumVitaeDao = curriculumVitaeDao;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public DataResult<List<CurriculumViate>> getAll() {

        return new SuccessDataResult<List<CurriculumViate>>
                (this.curriculumVitaeDao.findAll(),"Veriler Getirildi - CV");
    }

    @Override
    public Result add(CurriculumViate curriculumViate) {

        curriculumViate.setCreatedDate(LocalDate.now());
        this.curriculumVitaeDao.save(curriculumViate);
        return new SuccessResult("Başarılııııı");

        /*CurriculumViate resea = curriculumVitaeDao.save(curriculumViate);
        CurriculumVitaeHelper helper = new CurriculumVitaeHelper(eduHistoryDao,talentDao,languageDao,jobExperienceDao);
        helper.setAllCurriculumVitaeId();
                (resea.getEducation(), resea.getLanguages(),
                        resea.getTechnologies(), resea.getJobExperiences(), resea);
        return new SuccessResult("Kayıt Başarılı");*/
    }



    @Override
    public Result saveImage(MultipartFile file, int cvId) {
        try {
            Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
            String imageUrl= uploader.get("url");
            CurriculumViate cv = curriculumVitaeDao.getOne(cvId);
            cv.setPhoto(imageUrl);
            curriculumVitaeDao.save(cv);
        }catch (Exception e){
            return new ErrorResult("Geçersiz Medya Türü !");
        }

        return new SuccessResult("Fotoğraf Ekleme Başarılı");
    }

    @Override
    public DataResult<List<CurriculumViate>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CurriculumViate>>
                (this.curriculumVitaeDao.getByCandicate_Id(id));
    }
}
