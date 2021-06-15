package ulas.hrmsDemo.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_shifts")
public class WorkShift {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "work_shift_name")
    private String shiftName;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisements;
}
