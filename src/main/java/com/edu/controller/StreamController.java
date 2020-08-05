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

import com.edu.bean.Stream;
import com.edu.service.StreamService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Edu_rest")
public class StreamController {
	
	@Autowired
	StreamService streamservice;
	
	@RequestMapping(value = "/getStreams", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getStreams()
	{
		ObjectNode streamList = streamservice.getAllStreams();
		System.out.print("Returning all streams\n");
		return streamList;
	}

	@RequestMapping(value = "/getStream/{sid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getStream(@PathVariable int sid)
	{
		System.out.println("Got the sid=> "+sid);
		ObjectNode oneStream = streamservice.getStream(sid);
		System.out.println("Hopefully returned one stream");
		return oneStream;
	}

	@RequestMapping(value = "/insertStream", method = RequestMethod.POST, headers = "Accept=application/json")
	public ObjectNode insertStream(@RequestBody Stream stream) throws ClassNotFoundException, IOException, SQLException {		
		ObjectNode flag = streamservice.insertStream(stream);	
		System.out.println("Hopefully returned all streams ");
		return flag;
	}

	@RequestMapping(value="/updateStream", method=RequestMethod.POST, headers="Accept=application/json")
	public ObjectNode updateStream(@RequestBody Stream stream) throws ClassNotFoundException, IOException, SQLException
	{
		ObjectNode flag = streamservice.updateStream(stream);
		System.out.println("Hopefully updated stream..");
		return  flag;
	}

	@RequestMapping(value = "/inactivateStream", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ObjectNode inactivateStream(@RequestBody Stream stream) {		
		ObjectNode flag = streamservice.inactivateStream(stream);
		System.out.println("Hopefully deactivated stream");
		return flag;
	}
}
