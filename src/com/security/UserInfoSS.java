package com.security;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoSS implements UserDetails {

	private static final long serialVersionUID = -6640766834888660209L;
	private int id;
	private String userName;
	private String realName;
	private String password;
	private Date birthday;
	private String email;
	private String phone;
	private String mobilNo;
	private int sex;
	private Integer nationId;
	private Integer positionId;
	private Integer companyId;
	private Integer departmentId;
	private String companyName;
	private String departmentName;
	private int userType;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private Collection<GrantedAuthority> authorities;
	
	private Integer isSuperRole;//0���ǳ�������Ա��1�����ǳ�������Ա
	private Integer isManager;//0���ǹ���Ա��1�����ǹ���Ա


	public UserInfoSS(String userName, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = authorities;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getUsername() {
		return userName;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilNo() {
		return mobilNo;
	}

	public void setMobilNo(String mobilNo) {
		this.mobilNo = mobilNo;
	}
	
	public Integer getNationId() {
		return nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	/**
	 * ��ʦְ��ѧ��û��ְ��ĸ���
	 * @return
	 */
	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * �û����ͣ�0����ѧ��Ա��1��������Ա��2��ʵ������Ա��3���̸���Ա��4��Ƹ����Ա��5��������Ա��6��������Ա��7���೤��8��ѧ����9��������Ա��10������Ա
	 * @return
	 */
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * 0���ǳ�������Ա��1�����ǳ�������Ա
	 * @return
	 */
	public Integer getIsSuperRole() {
		return isSuperRole;
	}

	public void setIsSuperRole(Integer isSuperRole) {
		this.isSuperRole = isSuperRole;
	}

	/**
	 * 0���ǹ���Ա��1�����ǹ���Ա
	 * @return
	 */
	public Integer getIsManager() {
		return isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
