package com.mongo.seguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.seguridad.modelo.Role;
import com.mongo.seguridad.modelo.User;
import com.mongo.seguridad.repository.RoleRepository;
import com.mongo.seguridad.repository.UserRepository;

@Service
public class SeguridadService {
	@Autowired
	private UserRepository urepo;

	@Autowired
	private RoleRepository rrepo;

	public void saveUser(User user) {
		urepo.save(user);
	}

	public void saveRole(Role role) {
		rrepo.save(role);
	}

	public List<User> listUser() {
		return urepo.findAll();
	}

	public List<Role> listRoles() {
		return rrepo.findAll();
	}
}
