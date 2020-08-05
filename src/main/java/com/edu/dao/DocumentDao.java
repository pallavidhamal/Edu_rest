package com.edu.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.Document;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface DocumentDao {

	ObjectNode getAllDocuments();

	public ObjectNode getDocument(int sid);

	ObjectNode insertDocument(Document document) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateDocument(Document document);

	ObjectNode inactivateDocument(Document document);

}
