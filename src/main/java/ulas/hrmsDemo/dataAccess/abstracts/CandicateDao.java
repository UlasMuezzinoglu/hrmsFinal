package ulas.hrmsDemo.dataAccess.abstracts;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.Candicate;

public interface CandicateDao extends JpaRepository<Candicate, Integer> {

    boolean existsByIdentityNumber(String identityNumber);

}
