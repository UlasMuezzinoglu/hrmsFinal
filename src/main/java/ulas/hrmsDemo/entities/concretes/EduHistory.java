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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "edu_history")

public class EduHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CurriculumViate.class)
    @JoinColumn(name = "cv_id")
    private CurriculumViate curriculumViate;


    @Column(name = "school_name")
    @NotBlank(message = "Okul Adı Alanı Boş Geçilemez")
    private String schoolName;


    @ManyToOne(targetEntity = SchoolGrade.class)
    @JoinColumn(name = "grade_id",referencedColumnName = "id",nullable = false)
    private SchoolGrade gradeId;

    @Column(name = "faculty")
    @NotBlank(message = "Fakülte(Bölüm) Alanı Boş Geçilemez")
    private String faculty;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate;
}
