package com.plant.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8086644410654504210L;
	// Fields

	private Integer userId;
	private String userAccount;
	private String userName;
	private String userPassword;
	private String userHead;
	private Short userSex;
	private String userPhone;
	private String userQq;
	private String userWechat;
	private Timestamp userCreateTime;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Book> books = new HashSet<Book>(0);
	private Set<Collection> collections = new HashSet<Collection>(0);
	private Set<Privilege> privileges = new HashSet<Privilege>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userAccount, String userName, String userPassword,
			String userPhone, Timestamp userCreateTime) {
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userCreateTime = userCreateTime;
	}

	/** full constructor */
	public User(String userAccount, String userName, String userPassword,
			String userHead, Short userSex, String userPhone, String userQq,
			String userWechat, Timestamp userCreateTime, Set<Comment> comments,
			Set<Book> books, Set<Collection> collections, Set<Privilege> privileges) {
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userHead = userHead;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userQq = userQq;
		this.userWechat = userWechat;
		this.userCreateTime = userCreateTime;
		this.comments = comments;
		this.books = books;
		this.collections = collections;
		this.privileges = privileges;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserHead() {
		return this.userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public Short getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Short userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserWechat() {
		return this.userWechat;
	}

	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}

	public Timestamp getUserCreateTime() {
		return this.userCreateTime;
	}

	public void setUserCreateTime(Timestamp userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	public Set<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}