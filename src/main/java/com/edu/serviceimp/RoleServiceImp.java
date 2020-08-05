package com.edu.serviceimp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.bean.Role;
import com.edu.dao.RoleDao;
import com.edu.service.RoleService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RoleServiceImp implements RoleService {
	
	@Autowired	
	RoleDao roleDao;
	
	public ObjectNode getAllRoles()
	{
		ObjectNode rolesNode = roleDao.getAllRoles();
		System.out.println("Implemented service to return rolesNode");
		return rolesNode;
	}

	@Override
	public ObjectNode getRole(int sid)
	{
		ObjectNode oneRole = roleDao.getRole(sid);
		return oneRole;
	}

	@Override
	public ObjectNode insertRole(Role role) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode flag=roleDao.insertRole(role);
		return flag;
	}

	@Override
	public ObjectNode updateRole(Role role)
	{
		ObjectNode flag = roleDao.updateRole(role);
		System.out.println("Did I update role?");
		return flag;
	}

	@Override
	public ObjectNode inactivateRole(Role role)
	{
		ObjectNode flag = roleDao.inactivateRole(role);
		System.out.println("Did I deactivate role?");
		return flag;
	}
}