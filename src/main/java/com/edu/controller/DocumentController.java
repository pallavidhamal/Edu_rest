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

import com.edu.bean.Document;
import com.edu.service.DocumentService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Edu_rest")
public class DocumentController {
	
	@Autowired
	DocumentService documentservice;
	
	@RequestMapping(value = "/getDocuments", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getDocuments()
	{
		ObjectNode documentList = documentservice.getAllDocuments();
		System.out.print("Returning all documents\n");
		return documentList;
	}

	@RequestMapping(value = "/getDocument/{sid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ObjectNode getDocument(@PathVariable int sid)
	{
		System.out.println("Got the sid=> "+sid);
		ObjectNode oneDocument = documentservice.getDocument(sid);
		System.out.println("Hopefully returned one document");
		return oneDocument;
	}

	@RequestMapping(value = "/insertDocument", method = RequestMethod.POST, headers = "Accept=application/json")
	public ObjectNode insertDocument(@RequestBody Document document) throws ClassNotFoundException, IOException, SQLException {		
		ObjectNode flag = documentservice.insertDocument(document);	
		System.out.println("Hopefully returned all documents ");
		return flag;
	}

	@RequestMapping(value="/updateDocument", method=RequestMethod.POST, headers="Accept=application/json")
	public ObjectNode updateDocument(@RequestBody Document document) throws ClassNotFoundException, IOException, SQLException
	{
		ObjectNode flag = documentservice.updateDocument(document);
		System.out.println("Hopefully updated document..");
		return  flag;
	}

	@RequestMapping(value = "/inactivateDocument", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ObjectNode inactivateDocument(@RequestBody Document document) {		
		ObjectNode flag = documentservice.inactivateDocument(document);
		System.out.println("Hopefully deactivated document");
		return flag;
	}
}
