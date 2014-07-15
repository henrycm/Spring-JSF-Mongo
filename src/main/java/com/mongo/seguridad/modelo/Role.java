package com.mongo.seguridad.modelo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role implements Serializable, Comparable<Role> {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Transient
	@Override
	public int compareTo(Role arg0) {
		return this.getId().compareTo(arg0.getId());
	}

}
