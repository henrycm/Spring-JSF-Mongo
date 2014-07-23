package com.mongo.seguridad.repository;

import java.util.List;

import com.mongo.seguridad.modelo.Role;

public interface RoleRepositoryCustom {
	public List<Role> buscarPorPermission(String permission);
}
