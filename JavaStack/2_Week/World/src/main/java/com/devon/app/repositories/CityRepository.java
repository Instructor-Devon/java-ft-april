package com.devon.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.devon.app.models.City;

public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findAll();
	
	@Query("SELECT ci FROM City ci JOIN ci.country co WHERE co.name = ?1 AND ci.population > 500000 ORDER BY ci.population DESC")
	List<City> bigCitiesByCountry(String country);
	
}
