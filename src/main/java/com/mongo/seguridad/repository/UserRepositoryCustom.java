package com.mongo.seguridad.repository;

import java.util.List;

import com.mongo.seguridad.modelo.User;

public interface UserRepositoryCustom {
	public List<User> buscarPorRole(String id);
}
