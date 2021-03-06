package com.pvj.response;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.pvj.constants.HTTPStatusCode;
import com.pvj.exception.GlobalResponseException;
import com.pvj.model.ErrorMessage;
import com.pvj.model.Item;
import com.pvj.model.ItemStatus;
import com.pvj.model.SuccessResponse;
import com.pvj.util.CommonUtil;

@Component
public class ItemResponse {

	public Item populateItemResponse(Item item) {
		Item itemObj = new Item();
		itemObj.setItemName(item.getItemName());
		itemObj.setItemPhoto(item.getItemPhoto());
		itemObj.setItemPrice(item.getItemPrice());
		itemObj.setItemQuality(item.getItemQuality());
		itemObj.setItemQuantity(item.getItemQuantity());
		itemObj.setItemRemarks(item.getItemRemarks());
		itemObj.setItemSize(item.getItemSize());
		itemObj.setItemStatus(ItemStatus.ORDER.toString());
		itemObj.setItemType(item.getItemType());
		itemObj.setItemWeight(item.getItemWeight());
		itemObj.setItemOrderImage(item.getItemOrderImage());
		itemObj.setItemImageMid(item.getItemImageMid());
		itemObj.setItemImageFinal(item.getItemImageFinal());
		itemObj.setOrderedDate(LocalDateTime.now());
		itemObj.setRodiumRemarks(item.getRodiumRemarks());
		itemObj.setStoneRemarks(item.getStoneRemarks());
		itemObj.setEnamelRemarks(item.getEnamelRemarks());
		itemObj.setItemLastUpdated(LocalDateTime.now().toString());
		itemObj.setItemCreatedBy(item.getItemCreatedBy());
		if(item.getItemWorkedBy()==null) {
			itemObj.setItemWorkedBy("null");
		}else {
			itemObj.setItemWorkedBy(item.getItemWorkedBy());
		}
		itemObj.setExpectedDeliveryTime(LocalDateTime.now().plusDays(15).toString());
		return itemObj;
	}
	
	public String populateErrorResponse(GlobalResponseException ex) {
        ErrorMessage error = new ErrorMessage(ex);
        return CommonUtil.getGsonInstance().toJson(error);
    }
	
	public Item populateItemObj(Item item, Item existItem) {
		Item itemObj = new Item();
		itemObj.setItemId(existItem.getItemId());
		itemObj.setItemName(item.getItemName());
		itemObj.setItemPhoto(item.getItemPhoto());
		itemObj.setItemPrice(item.getItemPrice());
		itemObj.setItemQuality(item.getItemQuality());
		itemObj.setItemQuantity(item.getItemQuantity());
		itemObj.setItemRemarks(item.getItemRemarks());
		itemObj.setItemSize(item.getItemSize());
		itemObj.setItemStatus(item.getItemStatus());
		itemObj.setItemType(item.getItemType());
		itemObj.setItemWeight(item.getItemWeight());
		itemObj.setOrderedDate(item.getOrderedDate());
		itemObj.setRodiumRemarks(item.getRodiumRemarks());
		itemObj.setStoneRemarks(item.getStoneRemarks());
		itemObj.setEnamelRemarks(item.getEnamelRemarks());
		itemObj.setItemLastUpdated(LocalDateTime.now().toString());
		itemObj.setItemCreatedBy(item.getItemCreatedBy());
		itemObj.setExpectedDeliveryTime(item.getExpectedDeliveryTime());
		itemObj.setItemWorkedBy(item.getItemWorkedBy());
		
		return itemObj;
	}
	
	public SuccessResponse populateSuccessResponse() {
		SuccessResponse response = new SuccessResponse();
		response.setStatusCode(HTTPStatusCode.ACCEPTED);
		return response;
	}
}
