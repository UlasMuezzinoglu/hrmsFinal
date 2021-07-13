package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "job_advertisements")

public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "job_of_number_position")
    private String jobOfNumberPosition;

    @Column(name = "end_of_job_date")
    private LocalDate endOfJobDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "photo")
    private String photo = "https://res.cloudinary.com/prodiggie/image/upload/v1623506775/Ads%C4%B1z_xvonsa.png";

    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;

    @Column(name = "full_description")
    private String fullDescription;



    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;


    @ManyToOne()
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne()
    @JoinColumn(name = "work_shift_id")
    private WorkShift workShift;


    @ManyToOne()
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "jobAdvertisement")
    private List<SchoolGrade> schoolGrades;
}
