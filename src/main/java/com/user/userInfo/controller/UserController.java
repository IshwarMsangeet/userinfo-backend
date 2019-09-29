package com.user.userInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.userInfo.dto.UserInfo;
import com.user.userInfo.entity.User;
import com.user.userInfo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/create")
	public User createUser(@RequestBody UserInfo user) {
		return userService.createUser(user);
	}

	@GetMapping(value = "/list")
	public List<User> getUserList() {
		return userService.userLists();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

	@GetMapping(value = "/search")
	public List<User> searchUsers(@RequestParam String item) {
		return userService.searchUsers(item);
	}
}
