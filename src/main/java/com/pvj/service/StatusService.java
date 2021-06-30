package com.pvj.service;

import static com.pvj.constants.ErrorMessages.SQL_CONNECTION_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvj.constants.UserConstants;
import com.pvj.db.ItemRepository;
import com.pvj.db.UserRepository;
import com.pvj.exception.GlobalResponseException;
import com.pvj.exception.SqlDBException;
import com.pvj.model.Item;
import com.pvj.model.ItemStatus;
import com.pvj.model.User;

@Service
public class StatusService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Item> statusReady(String user, String status) throws GlobalResponseException {
		try {
			LOGGER.info("Requesting db for statusReady");
			List<Item> itemList = getItemList();
			List<Item> statusResponse = null;
			String userType = checkUserType(user);
			if (userType.equals(UserConstants.SHOP)) {
				statusResponse = filterRecordsByUserAndStatus(user, status, itemList);
			} else if (userType.equals(UserConstants.WORKER)) {
				statusResponse = filterRecordByWorkerStatus(user, status, itemList);
			}
			LOGGER.info("Successfully fetched db with status : " + status);
			return statusResponse;

		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
		}

	}

	private String checkUserType(String user) throws GlobalResponseException {
		List<User> userList = getUserList();
		User userInfo = userList.stream().filter(User -> User.getUserShopName().equals(user)).findFirst().get();
		if (UserConstants.SHOP.equals(userInfo.getUserType().toString())) {
			return UserConstants.SHOP;
		} else if (UserConstants.WORKER.equals(userInfo.getUserType().toString())) {
			return UserConstants.WORKER;
		} else {
			return null;
		}
	}

	public List<Item> getItemList() throws GlobalResponseException {
		try {
			LOGGER.info("Fetching Item Records from DB");
			Iterable<Item> itemInfo = itemRepository.findAll();
			List<Item> itemList = new ArrayList<>();
			itemInfo.forEach(e -> itemList.add(e));
			LOGGER.info("Successfully Item Records from DB");
			return itemList;
		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
		}

	}

	public List<User> getUserList() throws GlobalResponseException {
		try {
			LOGGER.info("Fetching User Records from DB");
			Iterable<User> userInfo = userRepository.findAll();
			List<User> userList = new ArrayList<>();
			userInfo.forEach(e -> userList.add(e));
			LOGGER.info("Successfully User Records from DB");
			return userList;
		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
		}

	}

	public List<Item> filterRecordsByUserAndStatus(String user, String status, List<Item> itemList) {
		LOGGER.info("status : " + status.toUpperCase());
		List<Item> statusResponse = new ArrayList<>();
		status = status.toUpperCase();
		if (status.equals(ItemStatus.ORDER.toString())) {
			statusResponse = itemList.stream().filter(Item -> Item.getItemStatus().equals(ItemStatus.ORDER.toString())
					&& Item.getItemCreatedBy().equals(user)).collect(Collectors.toList());
		} else if (status.equals(ItemStatus.INPROGRESS.toString())) {
			statusResponse = itemList.stream().filter(e -> e.getItemStatus().equals(ItemStatus.INPROGRESS.toString())
					&& e.getItemCreatedBy().equals(user)).collect(Collectors.toList());
		} else if (status.equals(ItemStatus.OREDERED_DEW.toString())) {
			statusResponse = itemList.stream().filter(e -> e.getItemStatus().equals(ItemStatus.OREDERED_DEW.toString())
					&& e.getItemCreatedBy().equals(user)).collect(Collectors.toList());
		} else if (status.equals(ItemStatus.PENDING.toString())) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.PENDING.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.READY.toString())) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.READY.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.REJECTED.toString())) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.REJECTED.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		}
		return statusResponse;
	}

	public List<Item> filterRecordByWorkerStatus(String user, String status, List<Item> itemList) {
		LOGGER.info("status : " + status.toUpperCase());
		status = status.toUpperCase();
		List<Item> statusResponse = new ArrayList<>();
		if (ItemStatus.ORDER.toString().equals(status)) {
			statusResponse = itemList.stream().filter(Item -> Item.getItemStatus().equals(ItemStatus.ORDER.toString())
					&& Item.getItemWorkedBy().equals(user)).collect(Collectors.toList());
		} else if (ItemStatus.INPROGRESS.toString().equals(status)) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.INPROGRESS.toString()) && e.getItemWorkedBy().equals(user))
					.collect(Collectors.toList());
		} else if (ItemStatus.OREDERED_DEW.toString().equals(status)) {
			statusResponse = itemList.stream().filter(e -> e.getItemStatus().equals(ItemStatus.OREDERED_DEW.toString())
					&& e.getItemWorkedBy().equals(user)).collect(Collectors.toList());
		} else if (ItemStatus.PENDING.toString().equals(status)) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.PENDING.toString()) && e.getItemWorkedBy().equals(user))
					.collect(Collectors.toList());
		} else if (ItemStatus.READY.toString().equals(status)) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.READY.toString()) && e.getItemWorkedBy().equals(user))
					.collect(Collectors.toList());
		} else if (ItemStatus.REJECTED.toString().equals(status)) {
			statusResponse = itemList.stream().filter(
					e -> e.getItemStatus().equals(ItemStatus.REJECTED.toString()) && e.getItemWorkedBy().equals(user))
					.collect(Collectors.toList());
		}
		return statusResponse;
	}

}
