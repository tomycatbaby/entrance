package com.entrance.service.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrance.bean.User;
import com.entrance.dao.UserDao;
import com.entrance.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public User getUser(String username) {
		return this.userDao.selectUser(username);
	}
	public void insertUser(User user) {
		this.userDao.insertUser(user);
		
	}
	public void updateUser(User user) {
		this.userDao.updateUser(user);
		
	}
	public List<User> getUserList(String username) {
		// TODO Auto-generated method stub
		return this.userDao.userList(username);
	}

}
