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

import com.edu.bean.College;
import com.edu.service.CollegeService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Edu_rest")
public class CollegeController {
	
	@Autowired
	CollegeService collegeservice;
	
	@RequestMapping(value = "/getColleges", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getColleges()
	{
		ObjectNode collegeList = collegeservice.getAllColleges();
		System.out.print("Returning all colleges\n");
		return collegeList;
	}

	@RequestMapping(value = "/getCollege/{sid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getCollege(@PathVariable int sid)
	{
		System.out.println("Got the sid=> "+sid);
		ObjectNode oneCollege = collegeservice.getCollege(sid);
		System.out.println("Hopefully returned one college");
		return oneCollege;
	}

	@RequestMapping(value = "/insertCollege", method = RequestMethod.POST, headers = "Accept=application/json")
	public ObjectNode insertCollege(@RequestBody College college) throws ClassNotFoundException, IOException, SQLException {		
		ObjectNode flag = collegeservice.insertCollege(college);	
		System.out.println("Hopefully returned all colleges ");
		return flag;
	}

	@RequestMapping(value="/updateCollege", method=RequestMethod.POST, headers="Accept=application/json")
	public ObjectNode updateCollege(@RequestBody College college) throws ClassNotFoundException, IOException, SQLException
	{
		ObjectNode flag = collegeservice.updateCollege(college);
		System.out.println("Hopefully updated college..");
		return  flag;
	}

	@RequestMapping(value = "/inactivateCollege", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ObjectNode inactivateCollege(@RequestBody College college) {		
		ObjectNode flag = collegeservice.inactivateCollege(college);
		System.out.println("Hopefully deactivated college");
		return flag;
	}
}
