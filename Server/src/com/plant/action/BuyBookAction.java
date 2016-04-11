package com.plant.action;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.plant.entity.Privilege;
import com.plant.entity.User;
import com.plant.util.HibernateProxyTypeAdapter;
import com.plant.util.JsonResult;

public class BuyBookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7608098270430715881L;

	private JsonResult jsonResult = new JsonResult();
	private int userId;
	private int bookId;
	
	public String execute() throws IOException {
		Gson gson = new GsonBuilder()
		.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
		.create();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		BookDao bookDao = new BookDaoImpl();
		UserDao userDao = new UserDaoImpl();
		
		Book book = bookDao.getBook(bookId);
		User seller = book.getUser();
		int book_coin = book.getBookCoin();
		int user_coin = userDao.getUserCoin(userId);
		int seller_coin = userDao.getUserCoin(seller.getUserId());
		
		if (user_coin >= book_coin) {
			short state = 2;
			book.setBookState(state);
			bookDao.saveBook(book);
			
			Privilege privilege = userDao.getUserPrivilege(userId);
			privilege.setUserCoin(user_coin - book_coin);
			userDao.savePrivilege(privilege);
			
			privilege = userDao.getUserPrivilege(seller.getUserId());
			privilege.setUserCoin(seller_coin + book_coin);
			userDao.savePrivilege(privilege);
			
			jsonResult.setStatus(1);
			out.println(gson.toJson(jsonResult));
			return null;
		} 
		jsonResult.setStatus(2);
		out.println(gson.toJson(jsonResult));
		return null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
}
