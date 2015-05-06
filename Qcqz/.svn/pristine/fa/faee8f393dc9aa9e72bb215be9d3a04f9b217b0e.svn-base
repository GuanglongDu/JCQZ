package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.Auth;
import com.qcqz.pageModel.TreeNode;

public interface MenuService {

	/**
	 * 获取菜单树
	 * 
	 * @param auth
	 * @param b
	 *            是否递归子节点
	 * @return
	 */
	public List<TreeNode> tree(Auth menu, Boolean b);

	/**
	 * 获得菜单treegrid
	 * 
	 * @param menu
	 * @return
	 */
	public List<Auth> treegrid(Auth menu);

	/**
	 * 删除菜单
	 * 
	 * @param menu
	 */
	public void delete(Auth menu);

	/**
	 * 添加菜单
	 * 
	 * @param menu
	 */
	public void add(Auth menu);

	/**
	 * 编辑菜单
	 * 
	 * @param menu
	 */
	public void edit(Auth menu);
	
	/**
	 * 查询所有菜单项
	 * 
	 * @param menu
	 */
	public List<Auth> findAll();

	public List<TreeNode> treeByUserId(String id);
	
}
