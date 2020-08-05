package com.edu.service;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.Document;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface DocumentService {

	ObjectNode getAllDocuments();

	ObjectNode getDocument(int sid);

	ObjectNode insertDocument(Document document) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateDocument(Document document);

	ObjectNode inactivateDocument(Document document);
}
