package com.model;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String password;
	private String realName;
	private String userType;
	private String academy;
	private String gradeInfo;
	private String phoneNumber;
	private Integer enabled;
	private Integer accountType;
	private Integer accountLevel;
	private Integer accountIntegral;
	private String picture1;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(Integer enabled, Integer accountType) {
		this.enabled = enabled;
		this.accountType = accountType;
	}

	/** full constructor */
	public Userinfo(String userName, String password, String realName,
			String userType, String academy, String gradeInfo,
			String phoneNumber, Integer enabled, Integer accountType,
			Integer accountLevel, Integer accountIntegral, String picture1) {
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.userType = userType;
		this.academy = academy;
		this.gradeInfo = gradeInfo;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.accountType = accountType;
		this.accountLevel = accountLevel;
		this.accountIntegral = accountIntegral;
		this.picture1 = picture1;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAcademy() {
		return this.academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getGradeInfo() {
		return this.gradeInfo;
	}

	public void setGradeInfo(String gradeInfo) {
		this.gradeInfo = gradeInfo;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getAccountType() {
		return this.accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountLevel() {
		return this.accountLevel;
	}

	public void setAccountLevel(Integer accountLevel) {
		this.accountLevel = accountLevel;
	}

	public Integer getAccountIntegral() {
		return this.accountIntegral;
	}

	public void setAccountIntegral(Integer accountIntegral) {
		this.accountIntegral = accountIntegral;
	}

	public String getPicture1() {
		return this.picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

}