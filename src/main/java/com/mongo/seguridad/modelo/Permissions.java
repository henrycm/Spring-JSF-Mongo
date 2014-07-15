package com.mongo.seguridad.modelo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Permissions implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
