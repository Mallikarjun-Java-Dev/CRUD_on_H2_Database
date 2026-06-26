package com.jdbc.h2crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.h2crud.model.User;
import com.jdbc.h2crud.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	    private final UserRepository userRepository;

	    public UserController(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @PostMapping
	    public String createUser(@RequestBody User user) {
	        userRepository.save(user);
	        return "User created successfully!";
	    }

	    @GetMapping
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public User getUserById(@PathVariable Long id) {
	        return userRepository.findById(id);
	    }

	    @PutMapping
	    public String updateUser(@RequestBody User user) {
	        userRepository.update(user);
	        return "User updated successfully!";
	    }

	    @DeleteMapping("/{id}")
	    public String deleteUser(@PathVariable Long id) {
	        userRepository.deleteById(id);
	        return "User deleted successfully!";
	    }
	

}
