package com.edu.serviceimp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bean.Document;
import com.edu.dao.DocumentDao;
import com.edu.service.DocumentService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class DocumentServiceImp implements DocumentService {
	
	@Autowired	
	DocumentDao documentDao;
	
	public ObjectNode getAllDocuments()
	{
		ObjectNode documentsNode = documentDao.getAllDocuments();
		System.out.println("Implemented service to return documentsNode");
		return documentsNode;
	}

	@Override
	public ObjectNode getDocument(int sid)
	{
		ObjectNode oneDocument = documentDao.getDocument(sid);
		return oneDocument;
	}

	@Override
	public ObjectNode insertDocument(Document document) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode flag=documentDao.insertDocument(document);
		return flag;
	}

	@Override
	public ObjectNode updateDocument(Document document)
	{
		ObjectNode flag = documentDao.updateDocument(document);
		System.out.println("Did I update document?");
		return flag;
	}

	@Override
	public ObjectNode inactivateDocument(Document document)
	{
		ObjectNode flag = documentDao.inactivateDocument(document);
		System.out.println("Did I deactivate document?");
		return flag;
	}
}