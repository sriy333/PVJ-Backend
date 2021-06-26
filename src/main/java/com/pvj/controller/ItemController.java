package com.pvj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pvj.exception.GlobalResponseException;
import com.pvj.model.Item;
import com.pvj.model.SuccessResponse;
import com.pvj.response.ItemResponse;
import com.pvj.service.ItemService;
import com.pvj.util.CommonUtil;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemResponse itemResponse;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
	
	@GetMapping(value = "/item/{itemId}", produces = "application/json")
	public String getItemById(@PathVariable("itemId") int itemId) {
		try {
			LOGGER.info("Initiating request for getById");
			Item response = itemService.getItemById(itemId);
			LOGGER.info("getById request successfully completed");
			return CommonUtil.getGsonInstance().toJson(response);
		}catch(GlobalResponseException ex) {
			return itemResponse.populateErrorResponse(ex);
		}
		
	}

	@PostMapping(value = "/item", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String postItem(@RequestBody String body) {
		try {
			LOGGER.info("Initiating request for creating item");
			Item itemResponse = itemService.saveItem(body);
			LOGGER.info("saveItem request successfully completed");
			return CommonUtil.getGsonInstance().toJson(itemResponse);
		} catch (GlobalResponseException ex) {
			return itemResponse.populateErrorResponse(ex);
		}
	}

	@GetMapping(value = "/item", produces = "application/json")
	public String getListOfItem() {
		try {
			LOGGER.info("Initiating request for getListOfItem");
			List<Item> response = itemService.getListOfItem();
			LOGGER.info("ListOfItem request successfully completed");
			return CommonUtil.getGsonInstance().toJson(response);
		}catch(GlobalResponseException ex) {
			return itemResponse.populateErrorResponse(ex);
		}
	}

	@PutMapping(value = "/item/{itemId}", produces = "application/json")
	public String putItem(@RequestBody String body, @PathVariable int itemId) {
		try {
			LOGGER.info("Initiating request for updating Item");
			Item response = itemService.updateItem(body, itemId);
			LOGGER.info("Successfully completed the item updated");
			return CommonUtil.getGsonInstance().toJson(response);
		}catch(GlobalResponseException ex) {
			return itemResponse.populateErrorResponse(ex);
		}
	}

	@DeleteMapping(value = "/item/{itemId}", produces = "application/json")
	public String deleteItem(@PathVariable int itemId) {
		try {
			LOGGER.info("Initiating request for delte item");
			SuccessResponse response = itemService.deleteItem(itemId);
			LOGGER.info("Successfully completed the item delete from db");
			return CommonUtil.getGsonInstance().toJson(response);
		}catch(GlobalResponseException ex) {
			return itemResponse.populateErrorResponse(ex);
		}
	}
}
