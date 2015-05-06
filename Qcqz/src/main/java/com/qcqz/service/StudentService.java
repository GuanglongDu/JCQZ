package com.qcqz.service;

import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Student;

public interface StudentService {

	public void save(Student student);

	public DataGrid datagrid(Student student);

	public void delete(String ids);

	public void update(Student student) ;
	
	public void classEdit(Student student);
	
}
