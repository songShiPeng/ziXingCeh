package com.model;

/**
 * Roleinfo entity. @author MyEclipse Persistence Tools
 */

public class Roleinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;

	// Constructors

	/** default constructor */
	public Roleinfo() {
	}

	/** full constructor */
	public Roleinfo(String roleName) {
		this.roleName = roleName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}