package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "school_grades")
@AllArgsConstructor
@NoArgsConstructor
public class SchoolGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "grade_name")
    @NotBlank(message = "Boş Geçilemez")
    private String gradeName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = JobAdvertisement.class)
    @JoinColumn(name = "jobadvertisement_id")
    private JobAdvertisement jobAdvertisement;


}
