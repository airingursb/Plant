package com.plant.util;

import java.sql.Timestamp;
import java.util.List;

public class JsonResult {

	private int status;
	
	//用户基本信息
	private int userId;
	private String userAccount;
	private String userName;
	private String userHead;
	private Short userSex;
	private String userPhone;
	private String userQq;
	private String userWechat;
	private Timestamp userCreateTime;
	
	//图书基本信息
	private List<BookListData> bookListData;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public Short getUserSex() {
		return userSex;
	}

	public void setUserSex(Short userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserWechat() {
		return userWechat;
	}

	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}

	public Timestamp getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Timestamp userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public List<BookListData> getBookListData() {
		return bookListData;
	}

	public void setBookListData(List<BookListData> bookListData) {
		this.bookListData = bookListData;
	}
	
	
	
	
}
