package com.devon.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devon.app.models.Country;
import com.devon.app.models.Language;
import com.devon.app.service.WorldService;

@RestController
public class ApiController {
	
	private final WorldService wService;
	public ApiController(WorldService service) {
		this.wService = service;
	}
	
	@RequestMapping("/")
	public List<Country> Index() {
		return this.wService.getCountries();
	}
	@RequestMapping("/c/{region}")
	public List<Country> ByRegion(@PathVariable("region") String region) {
		return this.wService.getCountriesByRegion(region);
	}
	@RequestMapping("/r")
	public List<Language> AllLangauges() {
		return this.wService.getLanguages();
	}
	@RequestMapping("/r/percentage")
	public List<Object[]> CountriesLangPerc() {
		return this.wService.getCountryLangPercentage();
	}
}
