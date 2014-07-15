package com.mongo.seguridad.modelo;

import java.io.Serializable;

public class Role_permissions implements Serializable {
	private static final long serialVersionUID = 1L;

	private String role;
	private String permission;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
