package com.devon.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devon.app.models.Idea;
import com.devon.app.models.User;
import com.devon.app.models.UserForm;
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
	public List<User> getUsersOrdered() {
		return this.uRepo.findByOrderByLastName();
	}
	public List<User> getAllUsersWithAddresses() {
		return this.uRepo.findByAddressIdIsNotNull();
	}
	public List<User> getAllUsersWithNoAddresses() {
		return this.uRepo.findByAddressIdIsNull();
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
	public User updateUser(Long id, UserForm userForm) {
		// query for user
		User toUpdate = this.uRepo.findById(id).orElse(null);
		if(toUpdate == null)
			return null;
		toUpdate.updateFromUserForm(userForm);
		return this.uRepo.save(toUpdate);
	}
	public User updateUser(User user) {
		return this.uRepo.save(user);
	}
	public void likeAnIdea(User user, Idea idea) {
		// get user's likedIdeas
		List<Idea> ideasLiked = user.getIdeasLiked();
		// we could prevent duplicate likes here
		if(!ideasLiked.contains(idea))
		// add idea to it (if not already there)
			ideasLiked.add(idea);
		else {
			ideasLiked.remove(idea);
		}
		// save user
		this.uRepo.save(user);
	}
}
