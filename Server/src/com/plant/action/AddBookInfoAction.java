package com.plant.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plant.dao.BookDao;
import com.plant.dao.BookDaoImpl;
import com.plant.dao.UserDao;
import com.plant.dao.UserDaoImpl;
import com.plant.entity.Book;
import com.plant.entity.User;
import com.plant.util.HibernateProxyTypeAdapter;
import com.plant.util.HttpRequest;
import com.plant.util.JsonResult;
import com.plant.util.MapUtil;

public class AddBookInfoAction extends ActionSupport implements Serializable, ModelDriven<Book> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5923177414114755126L;
	
	private MapUtil map = new MapUtil();
	private Book book = new Book();
	private JsonResult jsonResult = new JsonResult();
	private int userId;
	private int typeId;
	
	public String execute() throws IOException {
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(
				HibernateProxyTypeAdapter.FACTORY).create();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Short bookState = 0;
		Date time = new Date();
		Timestamp ts = new Timestamp(time.getTime());
		
		UserDao userDao = new UserDaoImpl();
		BookDao bookDao = new BookDaoImpl();
		User user = userDao.getUser(userId);
		book.setUser(user);
		book.setTypeId(typeId);
		book.setBookCoin(0);
		book.setBookState(bookState);
		book.setBookCover("http://121.42.113.192/Plant/images/default.png");
		book.setBookTime(ts);
		bookDao.saveBook(book);
		
		map.set_name(book.getBookName());
		map.set_location(book.getBookLatitude().toString() + "," + book.getBookLongitude().toString());
		
		String postResult = HttpRequest.sendPost("http://yuntuapi.amap.com/datamanage/data/create",
				"key=b443d3ea1afc1503f4cf573a1b27e051&tableid=5695e5ad305a2a2fb90ba018&data=" + gson.toJson(map));
		System.out.println("postResult:" + postResult);
		
		if (postResult.contains("OK")) { 
			jsonResult.setStatus(1);
		} else if (postResult.equals(null)) {
			jsonResult.setStatus(-1);
		} else {
			jsonResult.setStatus(0);
		}
		System.out.println(gson.toJson(jsonResult));
		out.println(gson.toJson(jsonResult));
		return null;
	}

	@Override
	public Book getModel() {
		return book;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



}
