package com.mongo.seguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.seguridad.modelo.Permission;
import com.mongo.seguridad.modelo.Role;
import com.mongo.seguridad.modelo.User;
import com.mongo.seguridad.repository.PermissionRepository;
import com.mongo.seguridad.repository.RoleRepository;
import com.mongo.seguridad.repository.UserRepository;

@Service
public class SeguridadService {
	@Autowired
	private UserRepository urepo;

	@Autowired
	private RoleRepository rrepo;

	@Autowired
	private PermissionRepository prepo;

	public void saveUser(User user) {
		urepo.save(user);
	}

	public Role saveRole(Role role) throws Exception {
		if (role.getId() == null) {
			Role r = rrepo.findByName(role.getName());
			if (r != null)
				if (role.getName().equalsIgnoreCase(r.getName()))
					throw new Exception("Un role con el mismo nombre ya existe");
		}
		return rrepo.save(role);
	}

	public void deleteUser(User user) {
		urepo.delete(user.getUsername());
	}

	public void deleteRole(Role role) throws Exception {
		List<User> lst = urepo.buscarPorRole(role.getId());
		if (lst != null && lst.size() > 0)
			throw new Exception("Existen usuarios con el rol!");
		rrepo.delete(role.getId());
	}

	public void deletePermission(Permission permission) {
		prepo.delete(permission.getId());
	}

	public void savePermission(Permission perm) throws Exception {
		if (perm.getId() == null) {
			Permission p = prepo.findByName(perm.getName());
			if (p != null)
				if (perm.getName().equalsIgnoreCase(p.getName()))
					throw new Exception("Un permiso con el mismo nombre ya existe");
		}
		prepo.save(perm);
	}

	public List<User> listUser() {
		return urepo.findAll();
	}

	public List<Role> listRoles() {
		return rrepo.findAll();
	}

	public List<Permission> listPermissions() {
		return prepo.findAll();
	}
}
