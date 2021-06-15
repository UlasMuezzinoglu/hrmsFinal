package ulas.hrmsDemo.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

    //private int id;
    private String jobTitle;
    private String jobOfNumberPosition;
    private Date publishDate;
    private LocalDate endOfJobDate;
    private String companyName;
}
