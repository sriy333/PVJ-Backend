package com.pvj.response;

import org.springframework.stereotype.Component;

import com.pvj.constants.HTTPStatusCode;
import com.pvj.exception.GlobalResponseException;
import com.pvj.model.ErrorMessage;
import com.pvj.model.SuccessResponse;
import com.pvj.model.User;
import com.pvj.util.CommonUtil;

@Component
public class UserResponse {

	public User populateUserResponse(User user) {
		User obj = new User();
		obj.setUserName(user.getUserName());
		obj.setPassword(user.getPassword());
		obj.setEmailId(user.getEmailId());
		obj.setGender(user.getGender());
		obj.setPhoneNumber(user.getPhoneNumber());
		obj.setUserShopName(user.getUserShopName());
		obj.setLastUpdated(user.getLastUpdated());
		obj.setLastUpdatedBy(user.getLastUpdatedBy());
		obj.setUserType(user.getUserType());
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

	public User populateUserObj(User user) {
		User obj = new User();
		obj.setUserId(user.getUserId());
		obj.setUserName(user.getUserName());
		obj.setPassword(user.getPassword());
		obj.setEmailId(user.getEmailId());
		obj.setGender(user.getGender());
		obj.setPhoneNumber(user.getPhoneNumber());
		obj.setUserShopName(user.getUserShopName());
		obj.setLastUpdated(user.getLastUpdated());
		obj.setLastUpdatedBy(user.getLastUpdatedBy());
		obj.setUserType(user.getUserType());
		obj.setUserScope(user.getUserScope());
		return obj;
		
	}
}
