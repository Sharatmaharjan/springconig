package com.app.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImp;
import com.app.model.User;

public class UserService {
@Autowired
UserDao userdao;

	public User login(User user){
		User user1=userdao.login(user);
		return user1;
	}
}
