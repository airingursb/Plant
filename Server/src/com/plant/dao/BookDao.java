package com.plant.dao;

import java.util.Set;

import com.plant.entity.Book;

public interface BookDao {

	//查询图书
	public Book getBook(int bookId);
	public int[] getBookIdByBookName(String bookName);		//精确
	public Set<Book> getBookByBookName(String bookName);	//模糊
	public Set<Book> getBooksByTypeId(int typeId, int pageNum);
	public Set<Book> getBooksByUserId(int userId, int pageNum);
	
	//添加图书
	public void saveBook(Book book);
	
	//主页接口
	public Set<Book> allBooks(int pageNum);
	
	
	
}
