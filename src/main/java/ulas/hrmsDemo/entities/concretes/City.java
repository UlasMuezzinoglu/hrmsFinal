package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_advertisements"})

public class City {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "city_name")
    String cityName;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisements;
}
