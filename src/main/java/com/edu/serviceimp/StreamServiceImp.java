package com.edu.serviceimp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bean.Stream;
import com.edu.dao.StreamDao;
import com.edu.service.StreamService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class StreamServiceImp implements StreamService {
	
	@Autowired	
	StreamDao streamDao;
	
	public ObjectNode getAllStreams()
	{
		ObjectNode streamsNode = streamDao.getAllStreams();
		System.out.println("Implemented service to return streamsNode");
		return streamsNode;
	}

	@Override
	public ObjectNode getStream(int sid)
	{
		ObjectNode oneStream = streamDao.getStream(sid);
		return oneStream;
	}

	@Override
	public ObjectNode insertStream(Stream stream) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode flag=streamDao.insertStream(stream);
		return flag;
	}

	@Override
	public ObjectNode updateStream(Stream stream)
	{
		ObjectNode flag = streamDao.updateStream(stream);
		System.out.println("Did I update stream?");
		return flag;
	}

	@Override
	public ObjectNode inactivateStream(Stream stream)
	{
		ObjectNode flag = streamDao.inactivateStream(stream);
		System.out.println("Did I deactivate stream?");
		return flag;
	}
}