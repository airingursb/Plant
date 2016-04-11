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

public class GetUserInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8588705174903123678L;

	private JsonResult jsonResult = new JsonResult();
	private int userId;
	private int pageNum;
	
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
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUser(userId);
		BookDao bookDao = new BookDaoImpl();
		int coin = userDao.getUserCoin(userId);
		
		Set<Book> books = new HashSet<Book>();
		
		if(bookDao.getBooksByUserId(userId, pageNum) != null) {
			books = bookDao.getBooksByUserId(userId, pageNum);
			List<Book> listData = new ArrayList<Book>(books);
			List<BookListData> list = new ArrayList<BookListData>();

			
			for (int i = 0; i < listData.size(); i++) {
				Book book = (Book) listData.get(i);
				User userSell = userDao.getUserByBookId(book.getBookId());
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
				data.setUserId(userSell.getUserId());
				data.setUserName(userSell.getUserName());
				data.setUserHead(userSell.getUserHead());
				list.add(data);
			}

			jsonResult.setStatus(1);
			jsonResult.setUserId(userId);
			jsonResult.setUserAccount(user.getUserAccount());
			jsonResult.setUserName(user.getUserName());
			jsonResult.setUserHead(user.getUserHead());
			jsonResult.setUserSex(user.getUserSex());
			jsonResult.setUserPhone(user.getUserPhone());
			jsonResult.setUserQq(user.getUserQq());
			jsonResult.setUserWechat(user.getUserWechat());
			jsonResult.setUserCreateTime(user.getUserCreateTime());
			jsonResult.setUserCoin(coin);
			jsonResult.setBookListData(list);
			jsonResult.setBuyBookData(list);
			out.println(gson.toJson(jsonResult));
			return null;
		}
		jsonResult.setStatus(0);
		out.println(gson.toJson(jsonResult));
		return null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
