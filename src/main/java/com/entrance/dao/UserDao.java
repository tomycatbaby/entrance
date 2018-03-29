package com.entrance.dao;



import java.util.List;

import com.entrance.bean.User;
public interface UserDao {
	User selectUser(String username);
	void insertUser(User user);
	void updateUser(User user);
	List<User> userList(String username);
}
