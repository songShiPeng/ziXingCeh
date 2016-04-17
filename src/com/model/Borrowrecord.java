package com.model;

/**
 * Borrowrecord entity. @author MyEclipse Persistence Tools
 */

public class Borrowrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String bicycleName;
	private Integer userId;
	private Integer bicycleId;
	private String borrowTime;
	private Integer isReturn;
	private String returnTime;
	private String borrowLocation;
	private String returnLocation;

	// Constructors

	/** default constructor */
	public Borrowrecord() {
	}

	/** full constructor */
	public Borrowrecord(String userName, String bicycleName, Integer userId,
			Integer bicycleId, String borrowTime, Integer isReturn,
			String returnTime, String borrowLocation, String returnLocation) {
		this.userName = userName;
		this.bicycleName = bicycleName;
		this.userId = userId;
		this.bicycleId = bicycleId;
		this.borrowTime = borrowTime;
		this.isReturn = isReturn;
		this.returnTime = returnTime;
		this.borrowLocation = borrowLocation;
		this.returnLocation = returnLocation;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBicycleName() {
		return this.bicycleName;
	}

	public void setBicycleName(String bicycleName) {
		this.bicycleName = bicycleName;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBicycleId() {
		return this.bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}

	public String getBorrowTime() {
		return this.borrowTime;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Integer getIsReturn() {
		return this.isReturn;
	}

	public void setIsReturn(Integer isReturn) {
		this.isReturn = isReturn;
	}

	public String getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getBorrowLocation() {
		return this.borrowLocation;
	}

	public void setBorrowLocation(String borrowLocation) {
		this.borrowLocation = borrowLocation;
	}

	public String getReturnLocation() {
		return this.returnLocation;
	}

	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
	}

}