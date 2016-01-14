package com.plant.dao;

import com.plant.entity.Privilege;
import com.plant.entity.User;

public interface UserDao {
	//获得用户
	public User getUser(int userId);
	public boolean getUserByAccount(String userAccount);
	public int getUserIdByAccount(String userAccount);
	public User getUserByBookId(int bookId);
	
	//保存用户
	public void saveUser(User user);
	public void savePrivilege(Privilege privilege);
	
	//相关业务
	public boolean login(User user);
}
