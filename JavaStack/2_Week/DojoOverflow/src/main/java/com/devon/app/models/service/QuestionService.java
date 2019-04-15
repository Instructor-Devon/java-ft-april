package com.devon.app.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devon.app.models.Question;
import com.devon.app.models.Tag;
import com.devon.app.repositories.QuestionRepository;
import com.devon.app.repositories.TagRepository;

@Service
public class QuestionService {
	
	private final QuestionRepository qRepo;
	private final TagRepository tRepo;
	public QuestionService(QuestionRepository qRepo, TagRepository tRepo) {
		this.qRepo = qRepo;
		this.tRepo = tRepo;
	}
	public List<Question> getAllQuestions() {
		return this.qRepo.findAll();
	}
	public Question createQuestion(Question question) {
		// unpack question.tagField into some sort of list of Strings...
		// "food, airplaines" => ["food", "airplanes"]
		String[] tagList = question.getTagField().split(",");
		// get all of the tags
		
		// loop tagList
		Tag tag;
		List<Tag> questionTags = new ArrayList<Tag>();
		for(String t: tagList) {
			// check if tag exists
			String trimmed = t.trim();
			tag = this.tRepo.findBySubject(trimmed).orElse(null);
			if(tag == null) {
				tag = new Tag(trimmed);
				this.tRepo.save(tag);
			}
			
			questionTags.add(tag);
		}
		question.setTags(questionTags);
		return this.qRepo.save(question);
//		return
	}
}
