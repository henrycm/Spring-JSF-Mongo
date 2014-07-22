package com.mongo.seguridad.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongo.seguridad.modelo.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	MongoTemplate template;

	@Override
	public List<User> buscarPorRole(String id) {
		Query q = new Query(new Criteria("roles.$id").is(new ObjectId(id)));
		return template.find(q, User.class);
	}
}
