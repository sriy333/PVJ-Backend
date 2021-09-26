package com.pvj.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvj.constants.UserConstants;
import com.pvj.exception.GlobalResponseException;
import com.pvj.model.User;
import com.pvj.service.UserService;

@Service
public class FlowPlannerUtil {

	private static UserService userService = new UserService();

	
	public  List<String> getShopListFCMToken() throws GlobalResponseException {
		List<User> shopList = getUserShopTypeList();
		List<String> userFcmTokenList = shopList.stream().map(x->x.getFcmToken()).collect(Collectors.toList());
		return userFcmTokenList;
	}
	
	public  List<String> getWorkerListFCMToken() throws GlobalResponseException {
		List<User> workerList = getWorkerTypeList();
		List<String> userFcmTokenList = workerList.stream().map(x->x.getFcmToken()).collect(Collectors.toList());
		return userFcmTokenList;
	}


	public  List<User> getUserShopTypeList() throws GlobalResponseException {
		List<User> userList = userService.getListOfUser();
		List<User> userShopTypeList = userList.stream().filter(x -> x.getUserType().equals(UserConstants.SHOP))
				.collect(Collectors.toList());
		return userShopTypeList;
	}

	public  List<User> getWorkerTypeList() throws GlobalResponseException {
		List<User> userList = userService.getListOfUser();
		List<User> userWorkerTypeList = userList.stream().filter(x -> x.getUserType().equals(UserConstants.WORKER))
				.collect(Collectors.toList());
		return userWorkerTypeList;
	}
}
