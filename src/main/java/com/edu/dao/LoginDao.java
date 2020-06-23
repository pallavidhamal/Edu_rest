package com.edu.dao;

import javax.servlet.http.HttpServletRequest;

import com.edu.bean.User;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface LoginDao {

	ObjectNode checkLoginCredential(User user,HttpServletRequest req);
	
	boolean checkEmailExistance(User user);
	
	ObjectNode checkSILoginCredential (User user);
	
	ObjectNode changePswd(User user);
	
	boolean saveUserKey(User user);

}
