package com.edu.serviceimp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bean.User;
import com.edu.dao.UserDao;
import com.edu.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired	
	UserDao userDao;
	
	public ObjectNode getAllUsers()
	{
		ObjectNode usersNode = userDao.getAllUsers();
		System.out.println("Implemented service to return usersNode");
		return usersNode;
	}

	@Override
	public ObjectNode getUser(int sid)
	{
		ObjectNode oneUser = userDao.getUser(sid);
		return oneUser;
	}

	@Override
	public ObjectNode insertUser(User user) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode flag=userDao.insertUser(user);
		return flag;
	}

	@Override
	public ObjectNode updateUser(User user)
	{
		ObjectNode flag = userDao.updateUser(user);
		System.out.println("Did I update user?");
		return flag;
	}

	@Override
	public ObjectNode inactivateUser(User user)
	{
		ObjectNode flag = userDao.inactivateUser(user);
		System.out.println("Did I deactivate user?");
		return flag;
	}
}