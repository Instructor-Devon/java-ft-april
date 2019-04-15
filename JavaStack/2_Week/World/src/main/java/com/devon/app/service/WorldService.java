package com.devon.app.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.devon.app.models.Country;
import com.devon.app.models.Language;
import com.devon.app.repositories.CountryRepository;
import com.devon.app.repositories.LanguageRepository;

@Service
public class WorldService {
	private final CountryRepository coRepo;
	private final LanguageRepository rRepo;
	public WorldService(CountryRepository coRepo, LanguageRepository rRepo) {
		this.coRepo = coRepo;
		this.rRepo = rRepo;
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
	public List<Object[]> getCountryLangPercentage() {
		return rRepo.countriesByLangPercentage();
	}
}
