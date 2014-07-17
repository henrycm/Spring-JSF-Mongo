package com.mongo.seguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.seguridad.modelo.Permission;
import com.mongo.seguridad.modelo.Role;
import com.mongo.seguridad.modelo.User;
import com.mongo.seguridad.repository.PermissionRepository;
import com.mongo.seguridad.repository.RoleRepository;
import com.mongo.seguridad.repository.UserRepository;

@Service
public class SeguridadService {
	@Autowired
	private UserRepository urepo;

	@Autowired
	private RoleRepository rrepo;

	@Autowired
	private PermissionRepository prepo;

	public void saveUser(User user) {
		urepo.save(user);
	}

	public Role saveRole(Role role) {
		return rrepo.save(role);
	}

	public void savePermission(Permission perm) {
		prepo.save(perm);
	}

	public List<User> listUser() {
		return urepo.findAll();
	}

	public List<Role> listRoles() {
		return rrepo.findAll();
	}

	public List<Permission> listPermissions() {
		return prepo.findAll();
	}
}
