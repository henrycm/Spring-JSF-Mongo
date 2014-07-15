package com.mongo.seguridad.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongo.seguridad.modelo.Role;
import com.mongo.seguridad.modelo.User;
import com.mongo.seguridad.service.SeguridadService;

@Component
@ViewScoped
public class UserMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(UserMB.class);

	@Autowired
	private SeguridadService bo;

	private User usr = new User();
	private Role role = new Role();
	private List<Role> roles;
	private List<User> users;

	@PostConstruct
	public void init() {
		roles = bo.listRoles();
		users = bo.listUser();
		logger.debug("No. Usuarios:" + users.size());
	}

	public void addRole() {
		role = new Role();
	}

	public void addUsr() {
		usr = new User();
	}

	public void guardar() {
		bo.saveUser(usr);
	}

	public void guardarRole() {
		bo.saveRole(role);
		roles.add(role);
	}

	// --------------------------------

	public List<User> getLista() {
		return users;
	}

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
