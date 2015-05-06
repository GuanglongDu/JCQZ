package com.qcqz.service;

import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Evalutative;

public interface StudentclassService {

	public void addCeping(Evalutative evalutative);
	
	public DataGrid queryEvalutative(Evalutative evalutative);
}
