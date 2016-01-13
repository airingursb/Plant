package com.plant.entity;

import java.sql.Timestamp;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */

public class Collection implements java.io.Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4573454618251547609L;
	// Fields

	private Integer collectionId;
	private Book book;
	private User user;
	private Timestamp collectionTime;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** full constructor */
	public Collection(Book book, User user, Timestamp collectionTime) {
		this.book = book;
		this.user = user;
		this.collectionTime = collectionTime;
	}

	// Property accessors

	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCollectionTime() {
		return this.collectionTime;
	}

	public void setCollectionTime(Timestamp collectionTime) {
		this.collectionTime = collectionTime;
	}

}