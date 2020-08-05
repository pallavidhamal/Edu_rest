package com.edu.serviceimp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bean.College;
import com.edu.dao.CollegeDao;
import com.edu.service.CollegeService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class CollegeServiceImp implements CollegeService {
	
	@Autowired	
	CollegeDao collegeDao;
	
	public ObjectNode getAllColleges()
	{
		ObjectNode collegesNode = collegeDao.getAllColleges();
		System.out.println("Implemented service to return collegesNode");
		return collegesNode;
	}

	@Override
	public ObjectNode getCollege(int sid)
	{
		ObjectNode oneCollege = collegeDao.getCollege(sid);
		return oneCollege;
	}

	@Override
	public ObjectNode insertCollege(College college) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode flag=collegeDao.insertCollege(college);
		return flag;
	}

	@Override
	public ObjectNode updateCollege(College college)
	{
		ObjectNode flag = collegeDao.updateCollege(college);
		System.out.println("Did I update college?");
		return flag;
	}

	@Override
	public ObjectNode inactivateCollege(College college)
	{
		ObjectNode flag = collegeDao.inactivateCollege(college);
		System.out.println("Did I deactivate college?");
		return flag;
	}
}