package com.scaffold.security.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scaffold.security.vo.Role;

@Repository
public interface RoleDao {

	/**
	 * 创建角色
	 * 
	 * @param role
	 * @return
	 */
	public Role createRole(Role role);

	/**
	 * 更新角色
	 * 
	 * @param role
	 * @return
	 */
	public Role updateRole(Role role);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 */
	public void deleteRole(Long roleId);

	/**
	 * 查找单一角色
	 * 
	 * @param roleId
	 * @return
	 */
	public Role findOne(Long roleId);

	/**
	 * 查找全部角色
	 * 
	 * @return
	 */
	public List<Role> findAll();

}
