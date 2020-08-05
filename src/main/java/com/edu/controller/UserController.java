package com.edu.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.bean.User;
import com.edu.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Edu_rest")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getUsers()
	{
		ObjectNode userList = userservice.getAllUsers();
		System.out.print("Returning all users\n");
		return userList;
	}

	@RequestMapping(value = "/getUser/{sid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getUser(@PathVariable int sid)
	{
		System.out.println("Got the sid=> "+sid);
		ObjectNode oneUser = userservice.getUser(sid);
		System.out.println("Hopefully returned one user");
		return oneUser;
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public ObjectNode insertUser(@RequestBody User user) throws ClassNotFoundException, IOException, SQLException {		
		ObjectNode flag = userservice.insertUser(user);	
		System.out.println("Hopefully returned all users ");
		return flag;
	}

	@RequestMapping(value="/updateUser", method=RequestMethod.POST, headers="Accept=application/json")
	public ObjectNode updateUser(@RequestBody User user) throws ClassNotFoundException, IOException, SQLException
	{
		ObjectNode flag = userservice.updateUser(user);
		System.out.println("Hopefully updated user..");
		return  flag;
	}

	@RequestMapping(value = "/inactivateUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ObjectNode inactivateUser(@RequestBody User user) {		
		ObjectNode flag = userservice.inactivateUser(user);
		System.out.println("Hopefully deactivated user");
		return flag;
	}
}
