package com.pvj.service;

import static com.pvj.constants.ErrorMessages.SQL_CONNECTION_EXCEPTION;
import static com.pvj.constants.ErrorMessages.USER_NAME_NOT_FOUND;
import static com.pvj.constants.HTTPStatusCode.INTERNAL_SERVER_ERROR;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvj.db.UserRepository;
import com.pvj.exception.GlobalResponseException;
import com.pvj.exception.SqlDBException;
import com.pvj.exception.UserNameNotFoundException;
import com.pvj.model.SuccessResponse;
import com.pvj.model.User;
import com.pvj.response.UserResponse;
import com.pvj.util.CommonUtil;
import com.pvj.util.UserValidationUtil;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserValidationUtil userValidationUtil;

	@Autowired
	private UserRepository userRepository;

	private UserResponse userResponse = new UserResponse();

	public User saveUser(String body) throws GlobalResponseException {
		LOGGER.debug("Navigating Request for validation");
		Boolean isValidated = userValidationUtil.PostRequestMandatoryParamCheck(body);
		if (isValidated) {
			userValidationUtil.postUserValidationRequest(body);
		}
		User user = CommonUtil.getGsonInstance().fromJson(body, User.class);
		User response = userResponse.populateUserResponse(user);
		LOGGER.info("Storing response to db");
		userRepository.save(response);
		LOGGER.info("Record db successfully completed");
		return response;
	}

	public List<User> getListOfUser() throws GlobalResponseException {
		try {
			LOGGER.info("Navigating Request for validation");
			List<User> userRecords = new ArrayList<>();
			Iterable<User> data = userRepository.findAll();
			data.forEach(e -> userRecords.add(e));
			return userRecords;
		} catch (Exception ex) {
			throw new GlobalResponseException("", "", SQL_CONNECTION_EXCEPTION, INTERNAL_SERVER_ERROR);
		}

	}

	public User getUserByName(String userName) throws GlobalResponseException {
		LOGGER.info("Navigating to DB for fetchging the record");
		try {
			List<User> userRecords = new ArrayList<>();
			Iterable<User> data = userRepository.findAll();
			data.forEach(e -> userRecords.add(e));
			Integer id = 0;
			for (User user : userRecords) {
				if (user.getUserName().equals(userName)) {
					id = user.getUserId();
					break;
				}
			}
			if (id != 0) {
				LOGGER.info("id found : " + id);
				return userRepository.findById(id).get();
			} else {
				throw new UserNameNotFoundException("", USER_NAME_NOT_FOUND);
			}
		} catch (Exception ex) {
			throw new SqlDBException("", ex.getMessage());
		}

	}

	public User updateUser(String body) throws GlobalResponseException {
		try {
			LOGGER.info("Updating user info in the db");
			User user = CommonUtil.getGsonInstance().fromJson(body, User.class);
			User existUserDetails = getUserByName(user.getUserName());
			User userInfo = userResponse.populateUserObj(user,existUserDetails);
			userRepository.save(userInfo);
			User response = userResponse.populateUserResponse(userInfo);
			return response;
		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
		}

	}

	public SuccessResponse deleteUser(String userName) throws GlobalResponseException {
		LOGGER.info("Deleting User from DB");
		User userInfo = getUserByName(userName);
		userRepository.delete(userInfo);
		return userResponse.populateSuccessResponse();

	}
}
