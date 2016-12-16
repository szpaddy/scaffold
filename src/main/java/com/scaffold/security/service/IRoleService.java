package com.scaffold.security.service;

import java.util.List;
import java.util.Set;

import com.scaffold.security.vo.Role;

public interface IRoleService {

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

	/**
	 * 根据角色编号得到角色标识符列表
	 * 
	 * @param roleIds
	 * @return
	 */
	public Set<String> findRoles(Long... roleIds);

	/**
	 * 根据角色编号得到权限字符串列表
	 * 
	 * @param roleIds
	 * @return
	 */
	public Set<String> findPermissions(Long[] roleIds);

}
