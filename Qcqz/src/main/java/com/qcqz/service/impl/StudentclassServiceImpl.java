package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TpropertyDAO;
import com.qcqz.dao.TstudentDAO;
import com.qcqz.dao.TstudentclassDAO;
import com.qcqz.domain.Tproperty;
import com.qcqz.domain.Tstudent;
import com.qcqz.domain.Tstudentclass;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Evalutative;
import com.qcqz.pageModel.Student;
import com.qcqz.service.StudentclassService;
@Service
public class StudentclassServiceImpl implements StudentclassService {

	@Autowired
	private TstudentclassDAO studentClassDao;
	@Autowired
	private TpropertyDAO propertyDao;
	@Autowired
	private TstudentDAO studentDao;
	
	@Override
	public void addCeping(Evalutative evalutative) {
		Tstudentclass sclass = new Tstudentclass();
		sclass.setCid(UUID.randomUUID().toString());
		sclass.setAssessment(evalutative.getAssessment());
		sclass.setCreatedate(new Date());
		Tproperty property = propertyDao.get(Tproperty.class, evalutative.getPropertyId());
		if(property != null)
			sclass.setTproperty(property);
		Tstudent student = studentDao.get(Tstudent.class, evalutative.getStudentId());
		if(student != null)
			sclass.setTstudent(student);
		studentClassDao.save(sclass);
	}

	public DataGrid queryEvalutative(Evalutative evalutative){
		DataGrid j = new DataGrid();
		j.setRows(this.changeModel(find(evalutative)));
		j.setTotal(this.total(evalutative));
		return j;
	}
	
	private Long total(Evalutative user) {
		String hql = "select count(*) from Tstudentclass t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		values.add(user.getStudentId());
		hql = addWhere(user, hql, values);
		return studentClassDao.count(hql, values);
	}
	
	private List<Evalutative> changeModel(List<Tstudentclass> tusers) {
		List<Evalutative> users = new ArrayList<Evalutative>();
		if (tusers != null && tusers.size() > 0) {
			for (Tstudentclass student : tusers) {
				Evalutative u = new Evalutative();
				u.setCid(student.getCid());
				u.setAssessment(student.getAssessment());
				u.setStudentId(student.getTstudent().getCid());
				u.setPropertyId(student.getTproperty().getCid());
				u.setCreatedate(student.getCreatedate());
				users.add(u);
				
			}
		}
		return users;
	}
	
	private List<Tstudentclass> find(Evalutative student) {
		String hql = "from Tstudentclass t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(student, hql, values);
		values.add(student.getStudentId());
		return studentClassDao.find(hql, values, student.getPage(), student.getRows());
	}
	
	private String addWhere(Evalutative user, String hql, List<Object> values) {
		hql += " and t.tstudent.cid = ? ";
		return hql;
	}
	
}
