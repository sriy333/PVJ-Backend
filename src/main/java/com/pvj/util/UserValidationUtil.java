package com.pvj.util;

import static com.pvj.constants.ErrorMessages.USERNAME_ALREADY_EXIST;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pvj.constants.ErrorMessages;
import com.pvj.constants.UserConstants;
import com.pvj.db.UserRepository;
import com.pvj.exception.BadRequestException;
import com.pvj.exception.GlobalResponseException;
import com.pvj.exception.InvalidUserNameException;
import com.pvj.exception.UserNameAlreadyExistException;
import com.pvj.model.User;

@Component
public class UserValidationUtil {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserValidationUtil.class);

	public void postUserValidationRequest(String body) throws GlobalResponseException {
		// aplication context
		LOGGER.info("Validating param of body");
		JsonObject json = new JsonParser().parse(body).getAsJsonObject();
		validateUsername(json);
		isUserNameUnique(json);
		return;
	}

	private void isUserNameUnique(JsonObject json) throws GlobalResponseException {
		LOGGER.info("Username is exist in db or not");
		String username = json.get(UserConstants.USERNAME).getAsString();
		Iterable<User> list = userRepository.findAll();
		List<User> userRecords = new ArrayList<>();
		list.forEach(e -> userRecords.add(e));
		List<User> isExist = userRecords.stream().filter(x -> x.getUserName().equals(username))
				.collect(Collectors.toList());
		System.out.println(isExist.size());
		if (isExist.size() > 0) {
			throw new UserNameAlreadyExistException("", USERNAME_ALREADY_EXIST);
		}
		return;
	}

	private void validateUsername(JsonObject json) throws GlobalResponseException {
		LOGGER.info("Validating the username without speical character");
		String username = json.get(UserConstants.USERNAME).getAsString();
		if (Pattern.matches(UserConstants.REGEX_ALLOW_ALL_CHARACTER, username)) {
			LOGGER.info("Validated username successfully");
			return;
		}
		throw new InvalidUserNameException("", ErrorMessages.INVALID_USERNAME_FORMAT);

	}

	public Boolean PostRequestMandatoryParamCheck(String body) throws BadRequestException {
		LOGGER.info("Validation request is initiated");
		StringBuilder errorMessage = new StringBuilder();
		JsonObject json = new JsonParser().parse(body).getAsJsonObject();
		if (!json.isJsonNull()) {
			if (json.get(UserConstants.USERNAME) == null
					|| (json.get(UserConstants.USERNAME) != null) && (json.get(UserConstants.USERNAME).isJsonNull())) {
				errorMessage.append("username");
			}

			if (json.get(UserConstants.PASSWORD) == null
					|| (json.get(UserConstants.PASSWORD) != null && (json.get(UserConstants.PASSWORD).isJsonNull()))) {
				errorMessage.append("password");
			}
			if (json.get(UserConstants.EMAIL_ID) == null
					|| (json.get(UserConstants.EMAIL_ID) != null && (json.get(UserConstants.EMAIL_ID).isJsonNull()))) {
				errorMessage.append("email id");
			}
			if (json.get(UserConstants.USER_SCOPE) == null || (json.get(UserConstants.USER_SCOPE) != null
					&& (json.get(UserConstants.USER_SCOPE).isJsonNull()))) {
				errorMessage.append("userScope");
			}
			if (json.get(UserConstants.USER_TYPE) == null || (json.get(UserConstants.USER_TYPE) != null
					&& (json.get(UserConstants.USER_TYPE).isJsonNull()))) {
				errorMessage.append("userType");
			}
			if (json.get(UserConstants.USER_SHOP_NAME) == null || (json.get(UserConstants.USER_SHOP_NAME) != null
					&& (json.get(UserConstants.USER_SHOP_NAME).isJsonNull()))) {
				errorMessage.append("userShopeName");
			}
			if (errorMessage.length() == 0) {
				LOGGER.info("All Mandatory parameter are received");
				LOGGER.info("Validation request is compeleted");
				return true;

			} else {
				throw new BadRequestException("log ref", ErrorMessages.MISSING_POST_BODY);
			}
		}
		throw new BadRequestException("log", ErrorMessages.MISSING_PARAMETER + errorMessage);

	}
}
