package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Role;

public interface RoleService {

	public DataGrid datagrid(Role role);

	public void add(Role role);

	public void edit(Role role);

	public void delete(String ids);

	public List<Role> combobox();
}
