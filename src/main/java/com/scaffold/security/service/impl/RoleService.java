package com.scaffold.security.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaffold.security.dao.RoleDao;
import com.scaffold.security.service.IResourceService;
import com.scaffold.security.service.IRoleService;
import com.scaffold.security.vo.Role;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private IResourceService resourceService;

	public Role createRole(Role role) {
		return roleDao.createRole(role);
	}

	public Role updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	public void deleteRole(Long roleId) {
		roleDao.deleteRole(roleId);
	}

	public Role findOne(Long roleId) {
		return roleDao.findOne(roleId);
	}

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public Set<String> findRoles(Long... roleIds) {
		Set<String> roles = new HashSet<String>();
		for (Long roleId : roleIds) {
			Role role = findOne(roleId);
			if (role != null) {
				roles.add(role.getRole());
			}
		}
		return roles;
	}

	public Set<String> findPermissions(Long[] roleIds) {
		Set<Long> resourceIds = new HashSet<Long>();
		for (Long roleId : roleIds) {
			Role role = findOne(roleId);
			if (role != null) {
				resourceIds.addAll(role.getResourceIds());
			}
		}
		return resourceService.findPermissions(resourceIds);
	}

}
