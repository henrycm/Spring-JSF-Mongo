package com.mongo.seguridad.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongo.seguridad.modelo.Permission;
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
	private Permission permission = new Permission();
	
	private List<Role> roles;
	private List<User> users;
	private List<Permission> permissions;

	@PostConstruct
	public void init() {
		roles = bo.listRoles();
		users = bo.listUser();
		permissions = bo.listPermissions();
		logger.debug("No. Usuarios:" + users.size());
	}

	public void addRole() {
		role = new Role();
	}

	public void addUsr() {
		usr = new User();
	}

	public void addPermission() {
		permission = new Permission();
	}
	
	public void guardar() {
		bo.saveUser(usr);
		users = bo.listUser();
	}

	public void guardarRole() {
		bo.saveRole(role);
		roles = bo.listRoles();
	}

	public void guardarPermission() {
		bo.savePermission(permission);
		permissions = bo.listPermissions();
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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
