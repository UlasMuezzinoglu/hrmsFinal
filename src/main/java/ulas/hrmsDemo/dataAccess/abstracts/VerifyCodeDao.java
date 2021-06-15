package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.VerifyCode;

public interface VerifyCodeDao extends JpaRepository<VerifyCode,Integer> {
    VerifyCode getByVerifyCode(String code);
    boolean existsByVerifyCode(String code);
}
