package com.edu.service;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.User;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface UserService {

	ObjectNode getAllUsers();

	ObjectNode getUser(int sid);

	ObjectNode insertUser(User user) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateUser(User user);

	ObjectNode inactivateUser(User user);
}
