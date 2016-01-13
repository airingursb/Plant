package com.plant.entity;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6799231856128226237L;
	
	// Fields

	private Integer commentId;
	private User user;
	private Book book;
	private String commentContent;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(User user, Book book, String commentContent,
			Timestamp commentTime) {
		this.user = user;
		this.book = book;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}