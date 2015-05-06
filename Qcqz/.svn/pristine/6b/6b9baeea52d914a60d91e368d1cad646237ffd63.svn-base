package com.qcqz.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TstudentDAO;
import com.qcqz.dao.TtestDAO;
import com.qcqz.domain.Tstudent;
import com.qcqz.domain.Ttest;
import com.qcqz.pageModel.Test;
import com.qcqz.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TstudentDAO studentDao;
	@Autowired
	private TtestDAO testDao;
	
	@Override
	public void addTest(Test test) {
		Tstudent student = studentDao.get(Tstudent.class,test.getStudentId());
		if(student != null){
			Ttest testq = new Ttest();
			testq.setCid(UUID.randomUUID().toString());
			testq.setCdesc(test.getCdesc());
			testq.settStudent(student);
			testDao.save(testq);
		}
	}

}
