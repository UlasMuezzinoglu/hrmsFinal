package ulas.hrmsDemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    @NotBlank
    private String passwordAgain;


    @JsonIgnore
    @Column(name="is_verified")
    private boolean isVerified;


}
