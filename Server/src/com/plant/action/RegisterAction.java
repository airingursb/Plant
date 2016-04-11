package com.plant.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plant.dao.UserDao;
import com.plant.dao.UserDaoImpl;
import com.plant.entity.Privilege;
import com.plant.entity.User;
import com.plant.util.HibernateProxyTypeAdapter;
import com.plant.util.JsonResult;
import com.plant.util.RegexUtil;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -173766186978576627L;
	private User user = new User();
	private JsonResult jsonResult = new JsonResult();
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
		Boolean exist = userDao.getUserByAccount(user.getUserAccount());
		if(exist == false){
			Short sex = 1;
			Date time = new Date();
			Timestamp ts = new Timestamp(time.getTime());
			user.setUserCreateTime(ts);
			user.setUserName(user.getUserAccount());
			user.setUserPhone(user.getUserAccount());
			user.setUserQq(null);
			user.setUserWechat(null);
			user.setUserSex(sex);
			user.setUserHead("http://121.42.195.113/Plant/images/default.png");
			userDao.saveUser(user);
			if(userDao.getUserByAccount(user.getUserAccount())){
				Privilege privilege = new Privilege();
				privilege.setUser(user);
				privilege.setUserLastTime(ts);
				privilege.setUserCoin(0);
				privilege.setUserLevel("1");
				userDao.savePrivilege(privilege);
				jsonResult.setStatus(1);
				jsonResult.setUserId(user.getUserId());
				jsonResult.setUserAccount(user.getUserAccount());
				jsonResult.setUserName(user.getUserName());
				jsonResult.setUserHead(user.getUserHead());
				jsonResult.setUserSex(user.getUserSex());
				jsonResult.setUserPhone(user.getUserPhone());
				jsonResult.setUserQq(user.getUserQq());
				jsonResult.setUserWechat(user.getUserWechat());
				jsonResult.setUserCreateTime(user.getUserCreateTime());
				out.println(gson.toJson(jsonResult));
				return null;
			}else{
				jsonResult.setStatus(0);
				System.out.println(gson.toJson(jsonResult));
				out.println(gson.toJson(jsonResult));
				return null;
			}
		} else if(exist == true) {
			jsonResult.setStatus(2);
			System.out.println(gson.toJson(jsonResult));
			out.println(gson.toJson(jsonResult));
			return null;
		}
		jsonResult.setStatus(-1);
		System.out.println(gson.toJson(jsonResult));
		out.println(gson.toJson(jsonResult));
		return null;
	}
	
	
	public void validate(){
		String userAccount = user.getUserAccount();
		String userPassword = user.getUserPassword();
		
		RegexUtil regex = new RegexUtil();
		Gson gson = new Gson();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
		PrintWriter out;
		try {
			out = response.getWriter();
			if(!regex.regexUserAccount(userAccount)){
				jsonResult.setStatus(1001);
				System.out.println(gson.toJson(jsonResult));
				out.println(gson.toJson(jsonResult));
				regexFlag = false;
				return;
			}
			if(!regex.regexUserPassword(userPassword)){
				jsonResult.setStatus(1003);
				System.out.println(gson.toJson(jsonResult));
				out.println(gson.toJson(jsonResult));
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
