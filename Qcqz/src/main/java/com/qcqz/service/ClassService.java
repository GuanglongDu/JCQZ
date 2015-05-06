package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.TreeNode;
import com.qcqz.pageModel.UserClass;

public interface ClassService {

	public List<TreeNode> tree(UserClass cclass, Boolean b);

	public List<UserClass> treegrid(UserClass cclass);

	public void delete(UserClass cclass);

	public void add(UserClass cclass);

	public void edit(UserClass cclass);
	
	public List<UserClass> findAll();
}
