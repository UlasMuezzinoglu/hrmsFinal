package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}
