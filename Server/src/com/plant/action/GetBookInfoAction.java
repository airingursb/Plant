package com.plant.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.plant.dao.BookDao;
import com.plant.dao.BookDaoImpl;
import com.plant.dao.UserDao;
import com.plant.dao.UserDaoImpl;
import com.plant.entity.Book;
import com.plant.entity.User;
import com.plant.util.BookListData;
import com.plant.util.HibernateProxyTypeAdapter;
import com.plant.util.JsonResult;

public class GetBookInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6054152197692190596L;
	private int bookId;
	private JsonResult jsonResult = new JsonResult();
	
	public String execute() throws IOException {
		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
				.create();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);  
		response.setContentType("text/json"); 
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		
		BookDao bookDao = new BookDaoImpl();
		UserDao userDao = new UserDaoImpl();
		Book book = bookDao.getBook(bookId);
		User user = userDao.getUserByBookId(bookId);
		
		
		jsonResult.setStatus(1);
		jsonResult.setUserId(user.getUserId());
		jsonResult.setBookId(book.getBookId());
		jsonResult.setBookAuthor(book.getBookAuthor());
		jsonResult.setBookCoin(book.getBookCoin());
		jsonResult.setBookContent(book.getBookContent());
		jsonResult.setBookCover(book.getBookCover());
		jsonResult.setBookImages(book.getBookImages());
		jsonResult.setBookIsbn(book.getBookIsbn());
		jsonResult.setBookLatitude(book.getBookLatitude());
		jsonResult.setBookLongitude(book.getBookLongitude());
		jsonResult.setBookLocation(book.getBookLocation());
		jsonResult.setBookName(book.getBookName());
		jsonResult.setBookPublishingCompany(book.getBookPublishingCompany());
		jsonResult.setBookPublishingTime(book.getBookPublishingTime());
		jsonResult.setBookState(book.getBookState());
		jsonResult.setBookTime(book.getBookTime());
		
		Set<Book> hotBooks = new HashSet<Book>();
		Set<Book> sugguestBooks = new HashSet<Book>();
		
		if(bookDao.allBooks(1) != null) {
			hotBooks = bookDao.allBooks(1);
			sugguestBooks = bookDao.allBooks(1);
			List<Book> hotListData = new ArrayList<Book>(hotBooks);
			List<BookListData> hotList = new ArrayList<BookListData>();
			List<Book> suggestListData = new ArrayList<Book>(sugguestBooks);
			List<BookListData> suggestList = new ArrayList<BookListData>();
			
			for (int i = 0; i < hotListData.size(); i++) {
				Book book1 = (Book) suggestListData.get(i);  
				User user1 = userDao.getUserByBookId(book.getBookId());
				BookListData data = new BookListData();

				data.setBookId(book1.getBookId());
				data.setBookAuthor(book1.getBookAuthor());
				data.setBookCover(book1.getBookCover());
				data.setBookName(book1.getBookName());
				data.setBookTime(book.getBookTime());
				data.setBookLocation(book1.getBookLocation());
				data.setBookLatitude(book1.getBookLatitude());
				data.setBookLongitude(book1.getBookLongitude());
				data.setBookIsbn(book1.getBookIsbn());
				data.setBookPublishingCompany(book1.getBookPublishingCompany());
				data.setBookPublishingTime(book1.getBookPublishingTime());
				data.setBookContent(book1.getBookContent());
				data.setBookCoin(book1.getBookCoin());
				data.setUserId(user1.getUserId());
				data.setUserName(user1.getUserName());
				data.setUserHead(user1.getUserHead());
				suggestList.add(data);
				hotList.add(data);
			}	
			jsonResult.setHotList(hotList);
			jsonResult.setSuggestList(suggestList);
		}
		out.println(gson.toJson(jsonResult));
		
		return null;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
}
