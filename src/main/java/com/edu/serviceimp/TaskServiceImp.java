package com.edu.serviceimp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bean.Task;
import com.edu.dao.TaskDao;
import com.edu.service.TaskService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class TaskServiceImp implements TaskService {

	@Autowired
	TaskDao taskDao;
	
	public ObjectNode getAllTasks(int userid) {
		ObjectNode orderNode = taskDao.getTasks(userid);
		return orderNode;
	}

	@Override
	public ObjectNode getTaskDetail(int id) {
		// TODO Auto-generated method stub
		ObjectNode orderNode = taskDao.getTaskDetail(id);
		return orderNode;
	}

	@Override
	public ObjectNode insertTask(Task task) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode flag=taskDao.insertTask(task);
		return flag;
	}

	@Override
	public ObjectNode updateTask(Task task) {
		// TODO Auto-generated method stub
		ObjectNode flag = taskDao.updateTask(task);
		return flag;
	}

	@Override
	public ObjectNode inactivateTask(Task task) {
		// TODO Auto-generated method stub
		ObjectNode flag = taskDao.inactivateTask(task); 
		return flag;	
	}

	@Override
	public ObjectNode activateTask(Task task) {
		// TODO Auto-generated method stub
		ObjectNode flag = taskDao.activateTask(task); 
		return flag;	
	}
	
}
