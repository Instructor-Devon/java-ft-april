package com.devon.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devon.app.models.User;
import com.devon.app.respositories.UserRepository;

@Service
public class UserService {
	private final UserRepository uRepo;
	public UserService(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	public List<User> getAllUsers() {
		return this.uRepo.findAll();
	}
	public List<User> getAllUsersByLastName(String lastName) {
		return this.uRepo.findByLastName(lastName);
	}
	public User findUserById(Long id) {
		Optional<User> user = this.uRepo.findById(id);
		return user.orElse(null);
	}
	public User createUser(User user) {
		return this.uRepo.save(user);
	}
	public User updateUser(Long id, String firstName, String lastName) {
		// query for user
		User toUpdate = this.uRepo.findById(id).orElse(null);
		if(toUpdate == null)
			return null;
		// call setters on user
		toUpdate.setFirstName(firstName);
		toUpdate.setLastName(lastName);
		// save user
		return this.uRepo.save(toUpdate);
	}
}
