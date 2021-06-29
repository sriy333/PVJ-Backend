package com.pvj.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private int itemId;
	@Column(name = "ITEM_NAME", length = 10, nullable = false, unique = false)
	private String itemName;
	@Column(name = "ITEM_STATUS")
	private ItemStatus itemStatus;
	@Column(name = "ITEM_TYPE")
	private String itemType;
	@Column(name = "ORDERED_DATE")
	private LocalDateTime orderedDate;
	@Column(name = "ITEM_PRICE")
	private long itemPrice;
	@Column(name = "ITEM_PHOTO")
	private String itemPhoto;
	@Column(name = "ITEM_QUANTITY")
	private int itemQuantity;
	@Column(name = "ITEM_QUALITY")
	private long itemQuality;
	@Column(name = "ITEM_SIZE")
	private long itemSize;
	@Column(name = "ITEM_WEIGHT")
	private long itemWeight;
	@Column(name = "EXPECTED_DELIVERY_TIME")
	private LocalDateTime expectedDeliveryTime;
	@Column(name = "ITEM_REMARKS")
	private String itemRemarks;
	@Column(name = "STONE_REMARKS")
	private String stoneRemarks;
	@Column(name = "ENAMEL_REMARKS")
	private String enamelRemarks;
	@Column(name = "RODIUM_REMARKS")
	private String rodiumRemarks;
	@Column(name = "ITEM_LAST_UPDATED_TIME")
	private LocalDateTime itemLastUpdated;
	@Column(name = "ITEM_CREATED_BY")
	private String itemCreatedBy;
	@Column(name = "ITEM_WORKED_BY")
	private String itemWorkedBy;

	public Item() {

	}

	public Item(int itemId, String itemName, ItemStatus itemStatus, String itemType, LocalDateTime orderedDate,
			long itemPrice, String itemPhoto, int itemQuantity, long itemQuality, long itemSize, long itemWeight,
			LocalDateTime expectedDeliveryTime, String itemRemarks, String stoneRemarks, String enamelRemarks,
			String rodiumRemarks, LocalDateTime itemLastUpdated, String itemCreatedBy, String itemWorkedBy) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemStatus = itemStatus;
		this.itemType = itemType;
		this.orderedDate = orderedDate;
		this.itemPrice = itemPrice;
		this.itemPhoto = itemPhoto;
		this.itemQuantity = itemQuantity;
		this.itemQuality = itemQuality;
		this.itemSize = itemSize;
		this.itemWeight = itemWeight;
		this.expectedDeliveryTime = expectedDeliveryTime;
		this.itemRemarks = itemRemarks;
		this.stoneRemarks = stoneRemarks;
		this.enamelRemarks = enamelRemarks;
		this.rodiumRemarks = rodiumRemarks;
		this.itemLastUpdated = itemLastUpdated;
		this.itemCreatedBy = itemCreatedBy;
		this.itemWorkedBy = itemWorkedBy;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemStatus getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public long getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(long itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemPhoto() {
		return itemPhoto;
	}

	public void setItemPhoto(String itemPhoto) {
		this.itemPhoto = itemPhoto;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public long getItemQuality() {
		return itemQuality;
	}

	public void setItemQuality(long itemQuality) {
		this.itemQuality = itemQuality;
	}

	public long getItemSize() {
		return itemSize;
	}

	public void setItemSize(long itemSize) {
		this.itemSize = itemSize;
	}

	public long getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(long itemWeight) {
		this.itemWeight = itemWeight;
	}

	public LocalDateTime getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}

	public void setExpectedDeliveryTime(LocalDateTime expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	public String getStoneRemarks() {
		return stoneRemarks;
	}

	public void setStoneRemarks(String stoneRemarks) {
		this.stoneRemarks = stoneRemarks;
	}

	public String getEnamelRemarks() {
		return enamelRemarks;
	}

	public void setEnamelRemarks(String enamelRemarks) {
		this.enamelRemarks = enamelRemarks;
	}

	public String getRodiumRemarks() {
		return rodiumRemarks;
	}

	public void setRodiumRemarks(String rodiumRemarks) {
		this.rodiumRemarks = rodiumRemarks;
	}

	public LocalDateTime getItemLastUpdated() {
		return itemLastUpdated;
	}

	public void setItemLastUpdated(LocalDateTime itemLastUpdated) {
		this.itemLastUpdated = itemLastUpdated;
	}

	public String getItemCreatedBy() {
		return itemCreatedBy;
	}

	public void setItemCreatedBy(String itemCreatedBy) {
		this.itemCreatedBy = itemCreatedBy;
	}

	public String getItemWorkedBy() {
		return itemWorkedBy;
	}

	public void setItemWorkedBy(String itemWorkedBy) {
		this.itemWorkedBy = itemWorkedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enamelRemarks == null) ? 0 : enamelRemarks.hashCode());
		result = prime * result + ((expectedDeliveryTime == null) ? 0 : expectedDeliveryTime.hashCode());
		result = prime * result + ((itemCreatedBy == null) ? 0 : itemCreatedBy.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemLastUpdated == null) ? 0 : itemLastUpdated.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemPhoto == null) ? 0 : itemPhoto.hashCode());
		result = prime * result + (int) (itemPrice ^ (itemPrice >>> 32));
		result = prime * result + (int) (itemQuality ^ (itemQuality >>> 32));
		result = prime * result + itemQuantity;
		result = prime * result + ((itemRemarks == null) ? 0 : itemRemarks.hashCode());
		result = prime * result + (int) (itemSize ^ (itemSize >>> 32));
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + (int) (itemWeight ^ (itemWeight >>> 32));
		result = prime * result + ((itemWorkedBy == null) ? 0 : itemWorkedBy.hashCode());
		result = prime * result + ((orderedDate == null) ? 0 : orderedDate.hashCode());
		result = prime * result + ((rodiumRemarks == null) ? 0 : rodiumRemarks.hashCode());
		result = prime * result + ((stoneRemarks == null) ? 0 : stoneRemarks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (enamelRemarks == null) {
			if (other.enamelRemarks != null)
				return false;
		} else if (!enamelRemarks.equals(other.enamelRemarks))
			return false;
		if (expectedDeliveryTime == null) {
			if (other.expectedDeliveryTime != null)
				return false;
		} else if (!expectedDeliveryTime.equals(other.expectedDeliveryTime))
			return false;
		if (itemCreatedBy == null) {
			if (other.itemCreatedBy != null)
				return false;
		} else if (!itemCreatedBy.equals(other.itemCreatedBy))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemLastUpdated == null) {
			if (other.itemLastUpdated != null)
				return false;
		} else if (!itemLastUpdated.equals(other.itemLastUpdated))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPhoto == null) {
			if (other.itemPhoto != null)
				return false;
		} else if (!itemPhoto.equals(other.itemPhoto))
			return false;
		if (itemPrice != other.itemPrice)
			return false;
		if (itemQuality != other.itemQuality)
			return false;
		if (itemQuantity != other.itemQuantity)
			return false;
		if (itemRemarks == null) {
			if (other.itemRemarks != null)
				return false;
		} else if (!itemRemarks.equals(other.itemRemarks))
			return false;
		if (itemSize != other.itemSize)
			return false;
		if (itemStatus != other.itemStatus)
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (itemWeight != other.itemWeight)
			return false;
		if (itemWorkedBy == null) {
			if (other.itemWorkedBy != null)
				return false;
		} else if (!itemWorkedBy.equals(other.itemWorkedBy))
			return false;
		if (orderedDate == null) {
			if (other.orderedDate != null)
				return false;
		} else if (!orderedDate.equals(other.orderedDate))
			return false;
		if (rodiumRemarks == null) {
			if (other.rodiumRemarks != null)
				return false;
		} else if (!rodiumRemarks.equals(other.rodiumRemarks))
			return false;
		if (stoneRemarks == null) {
			if (other.stoneRemarks != null)
				return false;
		} else if (!stoneRemarks.equals(other.stoneRemarks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemStatus=" + itemStatus + ", itemType="
				+ itemType + ", orderedDate=" + orderedDate + ", itemPrice=" + itemPrice + ", itemPhoto=" + itemPhoto
				+ ", itemQuantity=" + itemQuantity + ", itemQuality=" + itemQuality + ", itemSize=" + itemSize
				+ ", itemWeight=" + itemWeight + ", expectedDeliveryTime=" + expectedDeliveryTime + ", itemRemarks="
				+ itemRemarks + ", stoneRemarks=" + stoneRemarks + ", enamelRemarks=" + enamelRemarks
				+ ", rodiumRemarks=" + rodiumRemarks + ", itemLastUpdated=" + itemLastUpdated + ", itemCreatedBy="
				+ itemCreatedBy + ", itemWorkedBy=" + itemWorkedBy + "]";
	}

}
