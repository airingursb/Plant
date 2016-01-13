package com.plant.entity;

import java.sql.Timestamp;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */

public class Privilege implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2039925848499478159L;
	
	// Fields

	private Integer privilegeId;
	private User user;
	private Integer userCoin;
	private String userLevel;
	private Timestamp userLastTime;

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** minimal constructor */
	public Privilege(User user) {
		this.user = user;
	}

	/** full constructor */
	public Privilege(User user, Integer userCoin, String userLevel,
			Timestamp userLastTime) {
		this.user = user;
		this.userCoin = userCoin;
		this.userLevel = userLevel;
		this.userLastTime = userLastTime;
	}

	// Property accessors

	public Integer getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserCoin() {
		return this.userCoin;
	}

	public void setUserCoin(Integer userCoin) {
		this.userCoin = userCoin;
	}

	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public Timestamp getUserLastTime() {
		return this.userLastTime;
	}

	public void setUserLastTime(Timestamp userLastTime) {
		this.userLastTime = userLastTime;
	}

}