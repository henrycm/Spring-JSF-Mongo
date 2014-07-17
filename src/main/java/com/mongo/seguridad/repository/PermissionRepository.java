package com.mongo.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mongo.seguridad.modelo.Permission;

public interface PermissionRepository extends MongoRepository<Permission, String>, PagingAndSortingRepository<Permission, String> {

}
