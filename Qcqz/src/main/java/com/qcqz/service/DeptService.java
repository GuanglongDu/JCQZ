package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.Dept;
import com.qcqz.pageModel.TreeNode;

public interface DeptService {

	public List<TreeNode> tree(Dept dept, Boolean b);

	/**
	 * 获得部门treegrid
	 * 
	 * @param dept
	 * @return
	 */
	public List<Dept> treegrid(Dept dept);

	/**
	 * 删除部门
	 * 
	 * @param dept
	 */
	public void delete(Dept dept);

	/**
	 * 添加部门
	 * 
	 * @param dept
	 */
	public void add(Dept dept);

	/**
	 * 编辑部门
	 * 
	 * @param dept
	 */
	public void edit(Dept dept);
	
	/**
	 * 查询所有部门项
	 * 
	 * @param dept
	 */
	public List<Dept> findAll();
}
