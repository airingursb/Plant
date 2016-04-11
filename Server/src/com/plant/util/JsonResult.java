package com.plant.util;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.plant.entity.Book;
import com.plant.entity.Collection;
import com.plant.entity.Comment;
import com.plant.entity.User;

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
	private int userCoin;
	
	//图书基本信息
	private Book book;
	private User user;
	private Integer bookId;
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
	
	private List<BookListData> bookListData;
	private List<BookListData> hotList;
	private List<BookListData> suggestList;
	private List<BookListData> buyBookData;
	
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<BookListData> getHotList() {
		return hotList;
	}

	public void setHotList(List<BookListData> hotList) {
		this.hotList = hotList;
	}

	public List<BookListData> getSuggestList() {
		return suggestList;
	}

	public void setSuggestList(List<BookListData> suggestList) {
		this.suggestList = suggestList;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getBookCoin() {
		return bookCoin;
	}

	public void setBookCoin(Integer bookCoin) {
		this.bookCoin = bookCoin;
	}

	public Short getBookState() {
		return bookState;
	}

	public void setBookState(Short bookState) {
		this.bookState = bookState;
	}

	public String getBookLocation() {
		return bookLocation;
	}

	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}

	public Float getBookLatitude() {
		return bookLatitude;
	}

	public void setBookLatitude(Float bookLatitude) {
		this.bookLatitude = bookLatitude;
	}

	public Float getBookLongitude() {
		return bookLongitude;
	}

	public void setBookLongitude(Float bookLongitude) {
		this.bookLongitude = bookLongitude;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public String getBookImages() {
		return bookImages;
	}

	public void setBookImages(String bookImages) {
		this.bookImages = bookImages;
	}

	public String getBookContent() {
		return bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public Timestamp getBookTime() {
		return bookTime;
	}

	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublishingCompany() {
		return bookPublishingCompany;
	}

	public void setBookPublishingCompany(String bookPublishingCompany) {
		this.bookPublishingCompany = bookPublishingCompany;
	}

	public Timestamp getBookPublishingTime() {
		return bookPublishingTime;
	}

	public void setBookPublishingTime(Timestamp bookPublishingTime) {
		this.bookPublishingTime = bookPublishingTime;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Collection> getCollections() {
		return collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	public int getUserCoin() {
		return userCoin;
	}

	public void setUserCoin(int userCoin) {
		this.userCoin = userCoin;
	}

	public List<BookListData> getBuyBookData() {
		return buyBookData;
	}

	public void setBuyBookData(List<BookListData> buyBookData) {
		this.buyBookData = buyBookData;
	}

	
}
