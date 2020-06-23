package com.edu.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.Task;  
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface TaskDao {
	
	ObjectNode getTasks(int userid);
	
	public ObjectNode getTaskDetail(int id);
	
	ObjectNode insertTask(Task task) throws ClassNotFoundException, IOException, SQLException;
	
	ObjectNode updateTask(Task task);
	
	ObjectNode inactivateTask(Task task);

	ObjectNode activateTask(Task task);
	
}
