package com.plant.dao;

import java.util.Set;

import com.plant.entity.Book;

public interface BookDao {

	//查询图书
	public Book getBook(int bookId);
	public int[] getBookIdByBookName(String bookName);		//精确
	public Set<Book> getBookByBookName(String bookName);	//模糊
	
	//添加图书
	public void saveBook(Book book);
	
	//主页接口
	public Set<Book> allBooks(int pageNum);
	
}
