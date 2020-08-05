package com.edu.service;

import java.io.IOException;
import java.sql.SQLException;

import com.edu.bean.Role;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface RoleService {

	ObjectNode getAllRoles();

	ObjectNode getRole(int sid);

	ObjectNode insertRole(Role role) throws ClassNotFoundException, IOException, SQLException;

	ObjectNode updateRole(Role role);

	ObjectNode inactivateRole(Role role);
}
