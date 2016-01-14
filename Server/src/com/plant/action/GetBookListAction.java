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

public class GetBookListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5373466726908856160L;
	private JsonResult jsonResult = new JsonResult();
	private int pageNum;
	
	public String execute() throws IOException {
		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
				.create();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);  
		response.setContentType("text/json"); 
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDaoImpl();
		BookDao bookDao = new BookDaoImpl();
		Set<Book> books = new HashSet<Book>();
		
		if(bookDao.allBooks(pageNum) != null) {
			books = bookDao.allBooks(getPageNum());
			List<Book> bookList = new ArrayList<Book>(books);
			List<BookListData> list = new ArrayList<BookListData>();
			
			for (int i = 0; i < bookList.size(); i++)
			{
				Book book = (Book) bookList.get(i);  
				User user = userDao.getUserByBookId(book.getBookId());
				BookListData data = new BookListData();

				data.setBookId(book.getBookId());
				data.setBookAuthor(book.getBookAuthor());
				data.setBookCover(book.getBookCover());
				data.setBookName(book.getBookName());
				data.setBookTime(book.getBookTime());
				data.setBookLocation(book.getBookLocation());
				data.setBookLatitude(book.getBookLatitude());
				data.setBookLongitude(book.getBookLongitude());
				data.setBookIsbn(book.getBookIsbn());
				data.setBookPublishingCompany(book.getBookPublishingCompany());
				data.setBookPublishingTime(book.getBookPublishingTime());
				data.setBookContent(book.getBookContent());
				data.setUserId(user.getUserId());
				data.setUserName(user.getUserName());
				data.setUserHead(user.getUserHead());
				list.add(data);
			}	
			jsonResult.setStatus(1);
			jsonResult.setBookListData(list);
		}
		System.out.println(gson.toJson(jsonResult));
		out.println(gson.toJson(jsonResult));
		return null;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
