package com.devon.app.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.app.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	// SELECT * FROM users WHERE lastName = %1
	List<User> findByLastName(String lastName);
	List<User> findAll();
	// gets us homeless people
	List<User> findByAddressIdIsNull();
	// people with homes
	List<User> findByAddressIdIsNotNull();
	// findById(Long id);
	// save(User user);
}
