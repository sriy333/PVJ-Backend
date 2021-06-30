package com.pvj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME", length = 10, nullable = false, unique = false)
	private String userName;
	@Column(name = "USER_SHOP_NAME", length = 50, nullable = false, unique = false)
	private String userShopName;
	@Column(name = "USER_PASSWORD", length = 50, nullable = false, unique = false)
	private String password;
	@Column(name = "USER_PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "EMAIL_ID", length = 50, nullable = false, unique = false)
	private String emailId;
	@Enumerated(EnumType.STRING)
	@Column(name = "USER_SCOPE")
	private UserScope userScope;
	@Enumerated(EnumType.STRING)
	@Column(name = "USER_TYPE")
	private UserType userType;
	@Column(name = "LAST_UPDATED")
	private String lastUpdated;
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	public User() {
		
	}

	public User(int userId, String userName, String userShopName, String password, String phoneNumber, String gender,
			String emailId, UserScope userScope, UserType userType, String lastUpdated, String lastUpdatedBy) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userShopName = userShopName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.emailId = emailId;
		this.userScope = userScope;
		this.userType = userType;
		this.lastUpdated = lastUpdated;
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public User(String userName, String userShopName, String password, String emailId, UserScope userScope,
			UserType userType) {
		super();
		this.userName = userName;
		this.userShopName = userShopName;
		this.password = password;
		this.emailId = emailId;
		this.userScope = userScope;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserShopName() {
		return userShopName;
	}

	public void setUserShopName(String userShopName) {
		this.userShopName = userShopName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserScope getUserScope() {
		return userScope;
	}

	public void setUserScope(UserScope userScope) {
		this.userScope = userScope;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "userId=" + userId + ", userName=" + userName + ", userShopName=" + userShopName + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", emailId=" + emailId
				+ ", userScope=" + userScope + ", userType=" + userType + ", lastUpdated=" + lastUpdated
				+ ", lastUpdatedBy=" + lastUpdatedBy + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((lastUpdatedBy == null) ? 0 : lastUpdatedBy.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userScope == null) ? 0 : userScope.hashCode());
		result = prime * result + ((userShopName == null) ? 0 : userShopName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		User other = (User) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (lastUpdatedBy == null) {
			if (other.lastUpdatedBy != null)
				return false;
		} else if (!lastUpdatedBy.equals(other.lastUpdatedBy))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userScope != other.userScope)
			return false;
		if (userShopName == null) {
			if (other.userShopName != null)
				return false;
		} else if (!userShopName.equals(other.userShopName))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

}
