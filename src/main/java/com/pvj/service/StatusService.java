package com.pvj.service;

import static com.pvj.constants.ErrorMessages.SQL_CONNECTION_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			if (itemList.size() > 0) {
				statusResponse = filterRecordsByUserAndStatus(user, status, itemList);
			}
			LOGGER.info("Successfully fetched db with status : " + status);
			return statusResponse;

		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
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
			statusResponse = itemList.stream().filter(
					Item -> Item.getItemStatus().equals(ItemStatus.ORDER.toString()) && Item.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.INPROGRESS.toString())) {
			statusResponse = itemList.stream()
					.filter(e -> e.getItemStatus().equals(ItemStatus.INPROGRESS.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.OREDERED_DEW.toString())) {
			statusResponse = itemList.stream()
					.filter(e -> e.getItemStatus().equals(ItemStatus.OREDERED_DEW.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.PENDING.toString())) {
			statusResponse = itemList.stream()
					.filter(e -> e.getItemStatus().equals(ItemStatus.PENDING.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.READY.toString())) {
			statusResponse = itemList.stream()
					.filter(e -> e.getItemStatus().equals(ItemStatus.READY.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		} else if (status.equals(ItemStatus.REJECTED.toString())) {
			statusResponse = itemList.stream()
					.filter(e -> e.getItemStatus().equals(ItemStatus.REJECTED.toString()) && e.getItemCreatedBy().equals(user))
					.collect(Collectors.toList());
		}
		return statusResponse;
	}

}
