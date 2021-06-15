package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ulas.hrmsDemo.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    boolean existsByEmail(String mail);
}
