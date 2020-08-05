package com.edu.service;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.Stream;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface StreamService {

	ObjectNode getAllStreams();

	ObjectNode getStream(int sid);

	ObjectNode insertStream(Stream stream) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateStream(Stream stream);

	ObjectNode inactivateStream(Stream stream);
}
