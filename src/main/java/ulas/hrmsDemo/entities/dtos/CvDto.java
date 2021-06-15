package ulas.hrmsDemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ulas.hrmsDemo.entities.concretes.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    //@JsonIgnoreProperties({"password"})
    private Candicate candicateId;

    private List<EduHistory> eduHistories;

    private List<JobExperience> jobExperiences;

    private List<Talent> talents;

    private List<Language> languages;

    private String  photo;
}
