package com.qcqz.service;

import java.util.List;

import com.qcqz.pageModel.Categority;
import com.qcqz.pageModel.DataGrid;

public interface CategoriesService {

	public void save(Categority categority);

	public DataGrid datagrid(Categority categority);

	public void delete(String ids);

	public void update(Categority categority) ;
	
	public List<Categority> combobox();
}
