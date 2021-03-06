package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.TreeNode;
import com.qcqz.pageModel.User;

public interface UserService {

	public User login(User user);

	public void save(User user);

	public DataGrid datagrid(User user);

	public void delete(String ids);

	public void update(User user) ;

	public void roleEdit(User user);

	public void editUserInfo(User user);

	public List<TreeNode> getUserMenu(String id);
	
}
