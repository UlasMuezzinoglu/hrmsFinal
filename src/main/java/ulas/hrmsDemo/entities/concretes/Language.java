package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foreign_languages")

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CurriculumViate.class)
    @JoinColumn(name = "cv_id")
    private CurriculumViate curriculumViate;

    @NotBlank(message = "Dil Adı Alanı Boş Geçilemez")
    @Column(name = "language_name")
    private String languageName;


    //@NotBlank(message = "Dil Seviyesi Alanı Boş Geçilemez")
    @Column(name = "language_grade")
    private String  languageGrade;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate;

}
