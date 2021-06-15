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
@Table(name = "job_experiences")
@AllArgsConstructor
@NoArgsConstructor

public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = CurriculumViate.class)
    @JoinColumn(name = "cv_id")
    private CurriculumViate curriculumViate;

    @Column(name = "company_name")
    @NotBlank(message = "Şirket Adı Alanını Boş Geçemezsin")
    private String companyName;

    @Column(name = "position")
    @NotBlank(message = "İş Pozisyonu Alanını Boş Geçemezsin")
    private String position;

    @Column(name = "starting_date")
    //@NotBlank(message = "Başlama Tarihi Alanını Boş Geçemezsin")
    private LocalDate stardedDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonIgnore
    @Column(name = "created_date")
    private LocalDate createdDate;

}
