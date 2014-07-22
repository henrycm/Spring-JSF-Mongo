package com.mongo.seguridad.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;
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

	private List<String> selected_roles;
	private List<String> selected_permissions;

	@PostConstruct
	public void init() {
		roles = bo.listRoles();
		users = bo.listUser();
		permissions = bo.listPermissions();
		logger.debug("No. Usuarios:" + users.size());
	}

	public void addRole() {
		setRole(new Role());
	}

	public void addUsr() {
		setUsr(new User());
	}

	public void addPermission() {
		permission = new Permission();
	}

	public void guardar() {
		usr.setRoles(new ArrayList<Role>());
		for (String s : selected_roles)
			for (Role r : roles) {
				if (r.getId().equals(s)) {
					usr.getRoles().add(r);
					break;
				}
			}
		bo.saveUser(usr);
		users = bo.listUser();
	}

	public void eliminarUsr(User u) {
		bo.deleteUser(u);
		users = bo.listUser();
	}

	public void guardarRole() {
		role.setPermissions(new ArrayList<Permission>());
		for (String s : selected_permissions)
			for (Permission p : permissions) {
				if (p.getId().equals(s)) {
					role.getPermissions().add(p);
					break;
				}
			}
		try {
			bo.saveRole(role);
			roles = bo.listRoles();
		} catch (Exception e) {
			logger.warn(e);
			crearMensaje("Guardar", e.getMessage());
		}
	}

	public void eliminarRole(Role r) {
		try {
			bo.deleteRole(r);
			roles = bo.listRoles();
		} catch (Exception e) {
			logger.warn(e);
			crearMensaje("Eliminar", e.getMessage());
		}

	}

	public void eliminarPermission(Permission p) {
		bo.deletePermission(p);
		permissions = bo.listPermissions();
	}

	public void onRowEdit(RowEditEvent event) {
		permission = (Permission) event.getObject();
		guardarPermission();
	}

	public void guardarPermission() {
		try {
			bo.savePermission(permission);
			permissions = bo.listPermissions();
			crearMensaje("Permiso guardado", permission.getName());
		} catch (Exception e) {
			logger.warn(e);
			crearMensaje("Guardar", e.getMessage());
		}

	}

	private void crearMensaje(String tipo, String msg) {
		FacesMessage msg_ = new FacesMessage(tipo, msg);
		FacesContext.getCurrentInstance().addMessage(null, msg_);
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
		selected_roles = new ArrayList<String>();
		if (usr.getRoles() != null)
			for (Role r : usr.getRoles())
				selected_roles.add(r.getId());
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
		selected_permissions = new ArrayList<String>();
		if (role.getPermissions() != null)
			for (Permission p : role.getPermissions())
				selected_permissions.add(p.getId());
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

	public List<String> getSelected_roles() {
		return selected_roles;
	}

	public void setSelected_roles(List<String> selected_roles) {
		this.selected_roles = selected_roles;
	}

	public List<String> getSelected_permissions() {
		return selected_permissions;
	}

	public void setSelected_permissions(List<String> selected_permissions) {
		this.selected_permissions = selected_permissions;
	}

}
