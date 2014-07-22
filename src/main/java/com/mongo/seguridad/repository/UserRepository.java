package com.mongo.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mongo.seguridad.modelo.User;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom, PagingAndSortingRepository<User, String> {
}
