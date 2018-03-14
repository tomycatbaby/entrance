package com.entrance.dao;



import com.entrance.bean.User;
public interface UserDao {
	User selectUser(String username);
}
