package com.pvj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pvj.exception.GlobalResponseException;
import com.pvj.model.SuccessResponse;
import com.pvj.model.User;
import com.pvj.response.UserResponse;
import com.pvj.service.UserService;
import com.pvj.util.CommonUtil;

@RestController
@CrossOrigin
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@Autowired(required = true)
	private UserResponse userResponse;

	@GetMapping(value = "/user/{userName}", produces = "application/json")
	public String getUserById(@PathVariable("userName") String userName) {
		try {
			LOGGER.info("Initiating request for getById");
			User response = service.getUserByName(userName);
			LOGGER.info("getUserById is successfully completed");
			return CommonUtil.getGsonInstance().toJson(response);
		} catch (GlobalResponseException ex) {
			return userResponse.populateErrorResponse(ex);
		}

	}

	@PostMapping(value = "/user", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postUser(@RequestBody String body) {
		try {
			LOGGER.info("Initiating request for creating user");
			User response = service.saveUser(body);
			LOGGER.info("save user is successfully completed");
			return CommonUtil.getGsonInstance().toJson(response);
		} catch (GlobalResponseException ex) {
			return userResponse.populateErrorResponse(ex);
		}
	}

	@GetMapping(value = "/user", produces = "application/json")
	public String getListOfUser() {
		try {
			LOGGER.info("Initiating request for getListOfUser");
			List<User> response = service.getListOfUser();
			LOGGER.info("list of user is successfully completed");
			return CommonUtil.getGsonInstance().toJson(response);
		} catch (GlobalResponseException ex) {
			return userResponse.populateErrorResponse(ex);
		}
	}

	@PutMapping(value = "/user", produces = "application/json")
	public String putUser(@RequestBody String body) {
		try {
			LOGGER.info("Initiating put request for updating user info");
			User response = service.updateUser(body);
			LOGGER.info("Update user is successfully completed");
			return CommonUtil.getGsonInstance().toJson(response);
		} catch (GlobalResponseException ex) {
			return userResponse.populateErrorResponse(ex);
		}

	}

	@DeleteMapping(value = "/user/{userName}", produces = "application/json")
	public String deleteUser(@PathVariable("userName") String userName) {
		try {
			LOGGER.info("Initiating delete request for deleting user info from db");
			SuccessResponse response = service.deleteUser(userName);
			return CommonUtil.getGsonInstance().toJson(response);
		} catch (GlobalResponseException ex) {
			return userResponse.populateErrorResponse(ex);
		}
	}
}