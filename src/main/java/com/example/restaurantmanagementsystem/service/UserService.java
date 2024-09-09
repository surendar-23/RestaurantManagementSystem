package com.example.restaurantmanagementsystem.service;

import java.util.List;

import com.example.restaurantmanagementsystem.entity.User;

public interface UserService {
	User saveUser(User user);

	User loginUser(User user);

	User updateUser(User user, long userId);

	User getUserById(long userId);

	List<User> getAllUser();

	User getUserByEmail(User user);

	void deleteUser(long userId);
	
	boolean verifyUserDetails(User user);

}