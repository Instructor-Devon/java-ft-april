package com.devon.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.app.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	// write our queries
	List<Country> findAll();
	
	@Query("SELECT d FROM Country d WHERE d.region = ?1")
	List<Country> findCountiesByRegion(String region);
}
