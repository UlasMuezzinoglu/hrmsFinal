package ulas.hrmsDemo.core.utilities.helpers;

import ulas.hrmsDemo.dataAccess.abstracts.EduHistoryDao;
import ulas.hrmsDemo.dataAccess.abstracts.JobExperienceDao;
import ulas.hrmsDemo.dataAccess.abstracts.LanguageDao;
import ulas.hrmsDemo.dataAccess.abstracts.TalentDao;
import ulas.hrmsDemo.entities.concretes.*;

import java.util.List;

public class CurriculumVitaeHelper {

    private EduHistoryDao eduHistoryDao;
    private TalentDao talentDao;
    private LanguageDao languageDao;
    private JobExperienceDao jobExperienceDao;

    public CurriculumVitaeHelper(EduHistoryDao eduHistoryDao, TalentDao talentDao, LanguageDao languageDao,JobExperienceDao jobExperienceDao) {
        this.eduHistoryDao = eduHistoryDao;
        this.talentDao = talentDao;
        this.languageDao = languageDao;
        this.jobExperienceDao = jobExperienceDao;
    }

    public void setAllCurriculumVitaeId(List<EduHistory> edu, List<Language> lang, List<Talent> tal, List<JobExperience> exp, CurriculumViate curriculumViate)
    {
        setCurriculumVitaeEId(edu,curriculumViate);
        setCurriculumVitaeLId(lang,curriculumViate);
        setCurriculumVitaeTId(tal,curriculumViate);
        setCurriculumVitaeJId(exp,curriculumViate);
    }

    //
    // for EduHistory
    //
    public void setCurriculumVitaeEId(List<EduHistory> mapCv, CurriculumViate curriculumViatee)
    {
        if (mapCv == null)
        {
            //
        }else
        {
            for (EduHistory data : mapCv)
            {
                data.setCurriculumViate(curriculumViatee);
                this.eduHistoryDao.save(data);
            }
        }
    }

    //
    // end of EduHistory
    //
    //
    // for Languae
    //
    public void setCurriculumVitaeLId(List<Language> mapCv, CurriculumViate curriculumViatee)
    {
        if (mapCv == null)
        {
            //
        }else
        {
            for (Language data : mapCv)
            {
                data.setCurriculumViate(curriculumViatee);
                this.languageDao.save(data);
            }
        }
    }
    //
    // end of Language
    //
    //
    // for Talent
    //
    public void setCurriculumVitaeTId(List<Talent> mapCv, CurriculumViate curriculumViatee)
    {
        if (mapCv == null)
        {
            //
        }else
        {
            for (Talent data : mapCv)
            {
                data.setCurriculumViate(curriculumViatee);
                this.talentDao.save(data);
            }
        }
    }
    //
    // end of Talent
    //
    //
    // for JobExp
    //
    public void setCurriculumVitaeJId(List<JobExperience> mapCv, CurriculumViate curriculumViatee)
    {
        if (mapCv == null)
        {
            //
        }else
        {
            for (JobExperience data : mapCv)
            {
                data.setCurriculumViate(curriculumViatee);
                this.jobExperienceDao.save(data);
            }
        }
    }
    // end of JobExp
    //





}
