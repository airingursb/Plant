package com.plant.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2475258885381296359L;
	
	// Fields

	private Integer bookId;
	private User user;
	private Integer typeId;
	private Integer bookCoin;
	private Short bookState;
	private String bookLocation;
	private Float bookLatitude;
	private Float bookLongitude;
	private String bookCover;
	private String bookImages;
	private String bookContent;
	private Timestamp bookTime;
	private String bookName;
	private String bookAuthor;
	private String bookPublishingCompany;
	private Timestamp bookPublishingTime;
	private String bookIsbn;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Collection> collections = new HashSet<Collection>(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(User user, Integer typeId, Integer bookCoin, Short bookState,
			String bookCover, Timestamp bookTime, String bookName,
			String bookAuthor, String bookPublishingCompany) {
		this.user = user;
		this.typeId = typeId;
		this.bookCoin = bookCoin;
		this.bookState = bookState;
		this.bookCover = bookCover;
		this.bookTime = bookTime;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublishingCompany = bookPublishingCompany;
	}

	/** full constructor */
	public Book(User user, Integer typeId, Integer bookCoin, Short bookState,
			String bookLocation, Float bookLatitude, Float bookLongitude,
			String bookCover, String bookImages, String bookContent,
			Timestamp bookTime, String bookName, String bookAuthor,
			String bookPublishingCompany, Timestamp bookPublishingTime,
			String bookIsbn, Set<Comment> comments, Set<Collection> collections) {
		this.user = user;
		this.typeId = typeId;
		this.bookCoin = bookCoin;
		this.bookState = bookState;
		this.bookLocation = bookLocation;
		this.bookLatitude = bookLatitude;
		this.bookLongitude = bookLongitude;
		this.bookCover = bookCover;
		this.bookImages = bookImages;
		this.bookContent = bookContent;
		this.bookTime = bookTime;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublishingCompany = bookPublishingCompany;
		this.bookPublishingTime = bookPublishingTime;
		this.bookIsbn = bookIsbn;
		this.comments = comments;
		this.collections = collections;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getBookCoin() {
		return this.bookCoin;
	}

	public void setBookCoin(Integer bookCoin) {
		this.bookCoin = bookCoin;
	}

	public Short getBookState() {
		return this.bookState;
	}

	public void setBookState(Short bookState) {
		this.bookState = bookState;
	}

	public String getBookLocation() {
		return this.bookLocation;
	}

	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}

	public Float getBookLatitude() {
		return this.bookLatitude;
	}

	public void setBookLatitude(Float bookLatitude) {
		this.bookLatitude = bookLatitude;
	}

	public Float getBookLongitude() {
		return this.bookLongitude;
	}

	public void setBookLongitude(Float bookLongitude) {
		this.bookLongitude = bookLongitude;
	}

	public String getBookCover() {
		return this.bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public String getBookImages() {
		return this.bookImages;
	}

	public void setBookImages(String bookImages) {
		this.bookImages = bookImages;
	}

	public String getBookContent() {
		return this.bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public Timestamp getBookTime() {
		return this.bookTime;
	}

	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublishingCompany() {
		return this.bookPublishingCompany;
	}

	public void setBookPublishingCompany(String bookPublishingCompany) {
		this.bookPublishingCompany = bookPublishingCompany;
	}

	public Timestamp getBookPublishingTime() {
		return this.bookPublishingTime;
	}

	public void setBookPublishingTime(Timestamp bookPublishingTime) {
		this.bookPublishingTime = bookPublishingTime;
	}

	public String getBookIsbn() {
		return this.bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Collection> getCollections() {
		return this.collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

}