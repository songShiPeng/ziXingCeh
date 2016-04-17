package com.model;

/**
 * Bicycleinfo entity. @author MyEclipse Persistence Tools
 */

public class Bicycleinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bicycleNumber;
	private String adminId;
	private String purchaseYear;
	private Integer bicycleState;
	private String description;

	// Constructors

	/** default constructor */
	public Bicycleinfo() {
	}

	/** full constructor */
	public Bicycleinfo(String bicycleNumber, String adminId,
			String purchaseYear, Integer bicycleState, String description) {
		this.bicycleNumber = bicycleNumber;
		this.adminId = adminId;
		this.purchaseYear = purchaseYear;
		this.bicycleState = bicycleState;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBicycleNumber() {
		return this.bicycleNumber;
	}

	public void setBicycleNumber(String bicycleNumber) {
		this.bicycleNumber = bicycleNumber;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPurchaseYear() {
		return this.purchaseYear;
	}

	public void setPurchaseYear(String purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	public Integer getBicycleState() {
		return this.bicycleState;
	}

	public void setBicycleState(Integer bicycleState) {
		this.bicycleState = bicycleState;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}