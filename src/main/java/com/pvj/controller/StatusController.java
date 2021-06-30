package com.pvj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pvj.exception.GlobalResponseException;
import com.pvj.model.Item;
import com.pvj.service.StatusService;

@RestController
@CrossOrigin
public class StatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

	@Autowired
	private StatusService statusService;

	@GetMapping(value = "/status/{user}/{status}", produces = "application/json")
	public List<Item> getReadyStatus(@PathVariable String user,@PathVariable String status) throws GlobalResponseException {
		LOGGER.info("Initiating request for status : " + status);
		List<Item> response = statusService.statusReady(user, status);
		LOGGER.info("Successfully completed status " + status);
		return response;
	}
	
	
}
