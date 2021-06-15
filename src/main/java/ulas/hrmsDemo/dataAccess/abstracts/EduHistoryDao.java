package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.EduHistory;

public interface EduHistoryDao extends JpaRepository<EduHistory,Integer> {
}
