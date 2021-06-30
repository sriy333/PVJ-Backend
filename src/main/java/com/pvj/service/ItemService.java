package com.pvj.service;

import static com.pvj.constants.ErrorMessages.ITEM_NOT_FOUND;
import static com.pvj.constants.ErrorMessages.SQL_CONNECTION_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvj.db.ItemRepository;
import com.pvj.exception.GlobalResponseException;
import com.pvj.exception.ItemNotFoundException;
import com.pvj.exception.SqlDBException;
import com.pvj.model.Item;
import com.pvj.model.SuccessResponse;
import com.pvj.response.ItemResponse;
import com.pvj.util.CommonUtil;
import com.pvj.util.ItemValidationUtil;

@Service
public class ItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

	@Autowired
	private ItemValidationUtil itemValidationUtil;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemResponse itemResponse;

	public Item saveItem(String body) throws GlobalResponseException {
		LOGGER.info("Navigating for validation");
		Boolean isValidated = itemValidationUtil.postRequestItemManditoryCheckParam(body);
		Item item = null;
		if (isValidated) {
			item = CommonUtil.getGsonInstance().fromJson(body, Item.class);
		}
		Item response = itemResponse.populateItemResponse(item);
		LOGGER.info("Storing new item in db");
		itemRepository.save(response);
		LOGGER.info("Successfully new item recorded"+ response.toString());
		return response;
	}

	public List<Item> getListOfItem() throws GlobalResponseException {
		try {
			LOGGER.info("Requesting db for listofUsers");
			Iterable<Item> data = itemRepository.findAll();
			List<Item> list = new ArrayList<>();
			data.forEach(e -> list.add(e));
			return list;
		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
		}

	}

	public Item getItemById(int itemId) throws GlobalResponseException {
		LOGGER.info("Getting item form db");
		Item data = itemRepository.findById(itemId).get();
		if (data.getItemId() != itemId) {
			throw new ItemNotFoundException("", ITEM_NOT_FOUND);
		}
		return data;
	}

	public Item updateItem(String body, int itemId) throws GlobalResponseException {
		LOGGER.info("updating the item");
		Item existingItem = getItemById(itemId);
		Item item = CommonUtil.getGsonInstance().fromJson(body, Item.class);
		Item responseItem = itemResponse.populateItemObj(item, existingItem);
		itemRepository.save(responseItem);
		return responseItem;

	}

	public SuccessResponse deleteItem(int itemId) throws GlobalResponseException {
		LOGGER.info("updating the item");
		getItemById(itemId);
		itemRepository.deleteById(itemId);
		return itemResponse.populateSuccessResponse();
	}

}
