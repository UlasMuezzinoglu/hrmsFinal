package ulas.hrmsDemo.entities.concretes;

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



}
