package com.edu.service;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.College;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface CollegeService {

	ObjectNode getAllColleges();

	ObjectNode getCollege(int sid);

	ObjectNode insertCollege(College college) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateCollege(College college);

	ObjectNode inactivateCollege(College college);
}
