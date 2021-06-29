package com.pvj.util;

import static com.pvj.constants.ItemConstants.ITEM_CREATED_BY;
import static com.pvj.constants.ItemConstants.ITEM_NAME;
import static com.pvj.constants.ItemConstants.ITEM_QUALITY;
import static com.pvj.constants.ItemConstants.ITEM_QUANTITY;
import static com.pvj.constants.ItemConstants.ITEM_SIZE;
import static com.pvj.constants.ItemConstants.ITEM_WEIGHT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pvj.constants.ErrorMessages;
import com.pvj.exception.BadRequestException;
import com.pvj.exception.GlobalResponseException;

@Component
public class ItemValidationUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemValidationUtil.class);

	public boolean postRequestItemManditoryCheckParam(String body) throws GlobalResponseException {
		LOGGER.info("Validation request is initiated");
		StringBuilder errorMessage = new StringBuilder();
		JsonObject json = new JsonParser().parse(body).getAsJsonObject();
		if (!json.isJsonNull()) {
			if (json.get(ITEM_NAME) == null || ((json.get(ITEM_NAME) != null) && (json.get(ITEM_NAME).isJsonNull()))) {
				errorMessage.append("ITEM_NAME");
			}
			if (json.get(ITEM_QUANTITY) == null
					|| ((json.get(ITEM_QUANTITY) != null) && (json.get(ITEM_QUANTITY).isJsonNull()))) {
				errorMessage.append("ITEM_QUANTITY");
			}
			if (json.get(ITEM_SIZE) == null || ((json.get(ITEM_SIZE) != null) && (json.get(ITEM_SIZE).isJsonNull()))) {
				errorMessage.append("ITEM_SIZE");
			}
			if (json.get(ITEM_WEIGHT) == null
					|| ((json.get(ITEM_WEIGHT) != null && (json.get(ITEM_WEIGHT).isJsonNull())))) {
				errorMessage.append("ITEM_WEIGHT");
			}
			if (json.get(ITEM_QUALITY) == null
					|| ((json.get(ITEM_QUALITY) != null && (json.get(ITEM_QUALITY).isJsonNull())))) {
				errorMessage.append("ITEM_QUALITY");
			}
			if (json.get(ITEM_CREATED_BY) == null
					|| ((json.get(ITEM_CREATED_BY) != null && (json.get(ITEM_CREATED_BY).isJsonNull())))) {
				errorMessage.append("ITEM_CREATED_BY");
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

	public void postItemValidationUtil(String body) {
		LOGGER.info("Item Validation util params");
		JsonObject json = new JsonParser().parse(body).getAsJsonObject();
		return;
	}
}
