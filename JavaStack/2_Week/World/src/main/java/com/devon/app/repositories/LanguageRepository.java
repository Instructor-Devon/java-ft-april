package com.devon.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.devon.app.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
	List<Language> findAll();
	
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l ORDER BY l.percentage DESC")
	List<Object[]> countriesByLangPercentage();
}
