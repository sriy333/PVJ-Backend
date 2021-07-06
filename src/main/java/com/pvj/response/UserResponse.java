package com.pvj.response;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.pvj.constants.HTTPStatusCode;
import com.pvj.exception.GlobalResponseException;
import com.pvj.model.ErrorMessage;
import com.pvj.model.SuccessResponse;
import com.pvj.model.User;
import com.pvj.model.UserScope;
import com.pvj.model.UserType;
import com.pvj.util.CommonUtil;

@Component
public class UserResponse {

	public User populateUserResponse(User user) {
		User obj = new User();
		obj.setUserId(user.getUserId());
		obj.setUserName(user.getUserName());
		obj.setPassword(user.getPassword());
		obj.setEmailId(user.getEmailId());
		obj.setGender(user.getGender());
		obj.setPhoneNumber(user.getPhoneNumber());
		obj.setUserScope(UserScope.ADMIN_WRITE_READ);
		obj.setUserShopName(user.getUserShopName());
		obj.setLastUpdated(LocalDateTime.now().toString());
		obj.setLastUpdatedBy(user.getLastUpdatedBy());
		if(user.getUserType().equals(UserType.SHOP)) {
			obj.setUserType(UserType.SHOP);
		}else if(user.getUserType().equals(UserType.WORKER)) {
			obj.setUserType(UserType.WORKER);
		}else {
			obj.setUserType(null);
		}
		
		obj.setUserScope(user.getUserScope());
		return obj;
	}
	
	public String populateErrorResponse(GlobalResponseException ex) {
        ErrorMessage error = new ErrorMessage(ex);
        return CommonUtil.getGsonInstance().toJson(error);
    }
	
	public SuccessResponse populateSuccessResponse() {
		SuccessResponse response = new SuccessResponse();
		response.setStatusCode(HTTPStatusCode.ACCEPTED);
		return response;
	}

	public User populateUserObj(User user, User existingUserDetials) {
		User obj = new User();
		obj.setUserId(existingUserDetials.getUserId());
		obj.setUserName(user.getUserName());
		obj.setPassword(user.getPassword());
		obj.setEmailId(user.getEmailId());
		obj.setGender(user.getGender());
		obj.setPhoneNumber(user.getPhoneNumber());
		obj.setUserShopName(user.getUserShopName());
		obj.setLastUpdated(LocalDateTime.now().toString());
		obj.setLastUpdatedBy(user.getLastUpdatedBy());
		obj.setUserType(user.getUserType());
		obj.setUserScope(user.getUserScope());
		return obj;
		
	}
}
