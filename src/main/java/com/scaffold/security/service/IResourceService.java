package com.scaffold.security.service;

import java.util.List;
import java.util.Set;

import com.scaffold.security.vo.Resource;

public interface IResourceService {

	/**
	 * 增加资源
	 * 
	 * @param resource
	 * @return
	 */
	public Resource createResource(Resource resource);

	/**
	 * 更新资源
	 * 
	 * @param resource
	 * @return
	 */
	public Resource updateResource(Resource resource);

	/**
	 * 删除资源
	 * 
	 * @param resourceId
	 */
	public void deleteResource(Long resourceId);

	/**
	 * 查找单一资源
	 * 
	 * @param resourceId
	 * @return
	 */
	public Resource findOne(Long resourceId);

	/**
	 * 查找全部资源
	 * 
	 * @return
	 */
	public List<Resource> findAll();

	/**
	 * 得到资源对应的权限字符串
	 * 
	 * @param resourceIds
	 * @return
	 */
	public Set<String> findPermissions(Set<Long> resourceIds);

	/**
	 * 根据用户权限得到菜单
	 * 
	 * @param permissions
	 * @return
	 */
	public List<Resource> findMenus(Set<String> permissions);

	/**
	 * 根据用户权限查找子菜单
	 * 
	 * @param parent_id
	 *            父级菜单ID
	 * @param permissions
	 *            用户所拥有的权限
	 * @return
	 */
	public List<Resource> findMenus(Long parent_id, Set<String> permissions);

}
