package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.Property;
import com.qcqz.pageModel.TreeNode;

public interface PropertyService {

	public List<TreeNode> tree(Property dept, Boolean b);

	public List<Property> treegrid(Property dept);

	public void delete(Property dept);

	public void add(Property dept);

	public void edit(Property dept);
	
	public List<Property> findAll();

	public List<Property> getGroupBytpropertyId(Property dept);

	public List<TreeNode> treeCourse(Property dept, boolean b);
	
}
