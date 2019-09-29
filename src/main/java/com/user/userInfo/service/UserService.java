package com.user.userInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userInfo.dto.UserInfo;
import com.user.userInfo.entity.User;
import com.user.userInfo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public User createUser(UserInfo userInfo) {
		User user = new User();
		user.setUserName(userInfo.getUserName());
		user.setPhoneNumber(userInfo.getPhoneNumber());
		user.setAddress(userInfo.getAddress());
		return userRepo.save(user);
	}

	public List<User> userLists() {
		return userRepo.findAll();
	}

	public void deleteUser(String id) {
		 userRepo.deleteById(id);
	}

	public List<User> searchUsers(String item) {
		return userRepo.findUserByRegexString(item);
	}

}
