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

import com.edu.bean.Role;
import com.edu.service.RoleService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Edu_rest")
public class RoleController {
	
	@Autowired
	RoleService roleservice;
	
	@RequestMapping(value = "/getRoles", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getRoles()
	{
		ObjectNode roleList = roleservice.getAllRoles();
		System.out.print("Returning all roles\n");
		return roleList;
	}

	@RequestMapping(value = "/getRole/{sid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getRole(@PathVariable int sid)
	{
		System.out.println("Got the sid=> "+sid);
		ObjectNode oneRole = roleservice.getRole(sid);
		System.out.println("Hopefully returned one role");
		return oneRole;
	}

	@RequestMapping(value = "/insertRole", method = RequestMethod.POST, headers = "Accept=application/json")
	public ObjectNode insertRole(@RequestBody Role role) throws ClassNotFoundException, IOException, SQLException {		
		ObjectNode flag = roleservice.insertRole(role);	
		System.out.println("Hopefully returned all roles ");
		return flag;
	}

	@RequestMapping(value="/updateRole", method=RequestMethod.POST, headers="Accept=application/json")
	public ObjectNode updateRole(@RequestBody Role role) throws ClassNotFoundException, IOException, SQLException
	{
		ObjectNode flag = roleservice.updateRole(role);
		System.out.println("Hopefully updated role..");
		return  flag;
	}

	@RequestMapping(value = "/inactivateRole", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ObjectNode inactivateRole(@RequestBody Role role) {		
		ObjectNode flag = roleservice.inactivateRole(role);
		System.out.println("Hopefully deactivated role");
		return flag;
	}
}
