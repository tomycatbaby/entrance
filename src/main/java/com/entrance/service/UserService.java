package com.entrance.service;

import java.util.List;

import com.entrance.bean.User;

public interface UserService {
public User getUser(String username);
public void insertUser(User user); 
public void updateUser(User user);
public List<User> getUserList(String username);
}
