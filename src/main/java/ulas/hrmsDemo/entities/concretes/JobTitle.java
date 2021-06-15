package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_advertisements"})

public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "title")
    private String jobTitle;


    @JsonIgnore
    @OneToMany(mappedBy = "jobTitle")
    @Column(name = "id")
    private List<JobAdvertisement> jobAdvertisements;



    public JobTitle(){

    }
    public JobTitle(int id, String jobTitle){
        this.id = id;
        this.jobTitle = jobTitle;

    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }*/
}
