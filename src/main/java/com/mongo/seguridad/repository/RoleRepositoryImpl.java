package com.mongo.seguridad.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongo.seguridad.modelo.Role;

public class RoleRepositoryImpl implements RoleRepositoryCustom {

	@Autowired
	MongoTemplate template;

	@Override
	public List<Role> buscarPorPermission(String permission) {
		Query q = new Query(new Criteria("permissions.$id").is(new ObjectId(permission)));
		return template.find(q, Role.class);
	}

}
