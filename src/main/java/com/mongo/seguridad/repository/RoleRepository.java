package com.mongo.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mongo.seguridad.modelo.Role;

public interface RoleRepository extends MongoRepository<Role, String>, PagingAndSortingRepository<Role, String> {
	public Role findByName(String name);
}
