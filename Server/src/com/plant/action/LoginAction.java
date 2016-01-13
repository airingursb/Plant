package com.plant.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.plant.dao.UserDao;
import com.plant.dao.UserDaoImpl;
import com.plant.entity.User;
import com.plant.util.HibernateProxyTypeAdapter;
import com.plant.util.JsonResult;

public class LoginAction implements ModelDriven<User> {

	private User user = new User();
	private JsonResult result = new JsonResult();
	private Boolean regexFlag = true;
	
	public String execute() throws IOException {
		if(regexFlag == false){
			return null;
		}
		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
				.create();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);  
		response.setContentType("text/json"); 
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDaoImpl();
		if(userDao.login(user)){
			int userId = userDao.getUserIdByAccount(user.getUserAccount());
			User userInfo = userDao.getUser(userId);
			
			result.setStatus(1);
			result.setUserId(userInfo.getUserId());
			result.setUserAccount(userInfo.getUserAccount());
			result.setUserName(userInfo.getUserName());
			result.setUserHead(userInfo.getUserHead());
			result.setUserSex(userInfo.getUserSex());
			result.setUserPhone(userInfo.getUserPhone());
			result.setUserQq(userInfo.getUserQq());
			result.setUserWechat(userInfo.getUserWechat());
			result.setUserCreateTime(userInfo.getUserCreateTime());
			System.out.println(gson.toJson(result));
			out.println(gson.toJson(result));
			return null;
		}
		else if(!userDao.login(user)){
			result.setStatus(0);
			System.out.println(gson.toJson(result));
			out.println(gson.toJson(result));
			return null;
		}
		result.setStatus(-1);
		System.out.println(gson.toJson(result));
		out.println(gson.toJson(result));
		return null;
	}
	
	public void validate(){
		String userAccount = user.getUserAccount();
		String userPassword = user.getUserPassword();

		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
		PrintWriter out;
		try {
			out = response.getWriter();
			if(userAccount == null || userAccount.length() < 6){
				result.setStatus(1001);
				System.out.println(gson.toJson(result));
				out.println(gson.toJson(result));
				regexFlag = false;
				return;
			}
			if(userPassword == null || userPassword.length() < 6){
				result.setStatus(1003);
				System.out.println(gson.toJson(result));
				out.println(gson.toJson(result));
				regexFlag = false;
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User getModel() {
		return user;
	}

}
