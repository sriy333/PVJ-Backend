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
import com.pvj.exception.GlobalResponseException;
import com.pvj.exception.SqlDBException;
import com.pvj.model.Item;
import com.pvj.model.ItemStatus;

@Service
public class StatusService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> statusReady(String status) throws GlobalResponseException {
		try {
			LOGGER.info("Requesting db for statusReady");
			Iterable<Item> data = itemRepository.findAll();
			List<Item> list = new ArrayList<>();
			data.forEach(e -> list.add(e));
			List<Item> statusResponse = new ArrayList<>();
			LOGGER.info("status : "+ status.toUpperCase());
			status = status.toUpperCase();
			if (status.equals(ItemStatus.ORDER.toString())) {
				LOGGER.info(status+"is reached");
				statusResponse = list.stream().filter(e -> e.getItemStatus().equals(ItemStatus.ORDER))
						.collect(Collectors.toList());
			} else if (status.equals(ItemStatus.INPROGRESS.toString())) {
				statusResponse = list.stream().filter(e -> e.getItemStatus().equals(ItemStatus.INPROGRESS))
						.collect(Collectors.toList());
			} else if (status.equals(ItemStatus.OREDERED_DEW.toString())) {
				statusResponse = list.stream().filter(e -> e.getItemStatus().equals(ItemStatus.OREDERED_DEW))
						.collect(Collectors.toList());
			} else if (status.equals(ItemStatus.PENDING.toString())) {
				statusResponse = list.stream().filter(e -> e.getItemStatus().equals(ItemStatus.PENDING))
						.collect(Collectors.toList());
			} else if (status.equals(ItemStatus.READY.toString())) {
				statusResponse = list.stream().filter(e -> e.getItemStatus().equals(ItemStatus.READY))
						.collect(Collectors.toList());
			} else if (status.equals(ItemStatus.REJECTED.toString())) {
				statusResponse = list.stream().filter(e -> e.getItemStatus().equals(ItemStatus.REJECTED))
						.collect(Collectors.toList());
			}
			LOGGER.info("Successfully fetched db with status : "+ status);
			return statusResponse;
		} catch (Exception ex) {
			throw new SqlDBException("", SQL_CONNECTION_EXCEPTION);
		}

	}

}
