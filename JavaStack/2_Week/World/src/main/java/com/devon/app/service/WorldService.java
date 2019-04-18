package com.devon.app.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.devon.app.models.City;
import com.devon.app.models.Country;
import com.devon.app.models.Language;
import com.devon.app.repositories.CityRepository;
import com.devon.app.repositories.CountryRepository;
import com.devon.app.repositories.LanguageRepository;

@Service
public class WorldService {
	private final CountryRepository coRepo;
	private final LanguageRepository rRepo;
	private final CityRepository ciRepo;
	public WorldService(CountryRepository coRepo, LanguageRepository rRepo, CityRepository ciRepo) {
		this.coRepo = coRepo;
		this.rRepo = rRepo;
		this.ciRepo = ciRepo;
	}
	
	public List<Country> getCountries() {
		return this.coRepo.findAll();
	}
	public List<Country> getCountriesByRegion(String region) {
		return this.coRepo.findCountiesByRegion(region);
	}
	public List<Language> getLanguages() {
		return rRepo.findAll();
	}
	public List<City> getCities() {
		return this.ciRepo.findAll();
	}
	public List<Object[]> getCountriesCityCount() {
		return this.coRepo.countriesByCityCount();
	}
	public List<City> getBigCitiesByCountry(String country) {
		return this.ciRepo.bigCitiesByCountry(country);
	}
	public List<Object[]> getCountryLangPercentage() {
		return rRepo.countriesByLangPercentage();
	}
}
