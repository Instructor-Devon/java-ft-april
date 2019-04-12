package com.devon.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devon.app.models.Idea;
import com.devon.app.respositories.IdeasRepository;

@Service
public class IdeaService {
	private final IdeasRepository iRepo;
	public IdeaService(IdeasRepository iRepo) {
		this.iRepo = iRepo;
	}
	
	public List<Idea> getAllIdeas() {
		return this.iRepo.findAll();
	}

	public List<Idea> getIdeasFilteredByCreator(String nameSearch) {
		return this.iRepo.findByCreatorFirstNameContainingOrCreatorLastNameContaining(nameSearch, nameSearch);
	}

	public Idea createIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
}
