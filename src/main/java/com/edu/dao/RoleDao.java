package com.edu.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.Role;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface RoleDao {

	ObjectNode getAllRoles();

	public ObjectNode getRole(int sid);

	ObjectNode insertRole(Role role) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateRole(Role role);

	ObjectNode inactivateRole(Role role);

}
