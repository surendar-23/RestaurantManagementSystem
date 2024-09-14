package com.example.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantmanagementsystem.entity.User;
import com.example.restaurantmanagementsystem.exception.ResourceNotFoundException;
import com.example.restaurantmanagementsystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);

	}

	@Override
	public User loginUser(User user) {
	    return this.userRepository.findByEmailIdAndPassword(user.emailId, user.password).orElseThrow(
	            () -> new ResourceNotFoundException("User ", "Id", user.emailId + " and password " + user.password));
	}

	@Override
	public User updateUser(User user, long userId) {

		User existingUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setDateOfBirth(user.getDateOfBirth());
		existingUser.setDistrict(user.getDistrict());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		existingUser.setState(user.getState());
		existingUser.setZipCode(user.getZipCode());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setPassword(user.getPassword());
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public User getUserById(long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	 public User getUserByEmail(User user) {
        Optional<User> foundUser = userRepository.findByEmailId(user.getEmailId());
        return foundUser.orElse(null);
    }

	@Override
	public void deleteUser(long userId) {
		userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		userRepository.deleteById(userId);

	}
	
	@Override
	public boolean verifyUserDetails(User user) {
	    User storedUser = userRepository.findByEmailId(user.getEmailId())
	            .orElseThrow(() -> new ResourceNotFoundException("User", "EmailId", user.getEmailId()));
	    
	    return storedUser.getPhoneNumber().equals(user.getPhoneNumber())
	            && storedUser.getRole().equals(user.getRole());
	}


}