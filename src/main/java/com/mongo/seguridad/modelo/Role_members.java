package com.mongo.seguridad.modelo;

import java.io.Serializable;

public class Role_members implements Serializable {
	private static final long serialVersionUID = 1L;

	private String role;
	private String user;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
