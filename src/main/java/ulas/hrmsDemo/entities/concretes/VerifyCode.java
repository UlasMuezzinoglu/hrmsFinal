package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verify_codes")
public class VerifyCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @Column(name = "verify_code")
    private String verifyCode;

    @JsonIgnore
    @Column(name = "is_verified")
    private boolean isVerified;

    @JsonIgnore
    @Column(name = "verified_date")
    private LocalDate verifiedDate;

    @JsonIgnore
    @Column(name = "code_created_date")
    private LocalDate codeCreatedDate;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userId;
}
