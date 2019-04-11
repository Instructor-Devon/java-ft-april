package com.devon.app.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devon.app.models.Idea;

public interface IdeasRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
}
