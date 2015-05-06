package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TclassDAO;
import com.qcqz.dao.TstudentDAO;
import com.qcqz.domain.Tclass;
import com.qcqz.domain.Tstudent;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Student;
import com.qcqz.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private TstudentDAO studentDao;
	@Autowired
	private TclassDAO classDao;
	
	@Override
	public void save(Student student) {
		Tstudent u = new Tstudent();
		if (isUniqueUser(student.getCode(), null)) {
			String exception = "用户名已存在,请重新输入. ";
		}
		u.setAddress(student.getAddress());
		u.setBirthday(student.getBirthday());
		u.setCode(student.getCode());
		u.setFatherMobile(student.getFatherMobile());
		u.setFatherName(student.getFatherName());
		u.setGender(student.getGender());
		u.setMotherMobile(student.getMotherMobile());
		u.setMotherName(student.getMotherName());
		u.setName(student.getName());
		u.setOtherConnect(student.getOtherConnect());
		u.setOtherConnectMobile(student.getOtherConnectMobile());
		u.setPy(student.getPy());
		u.setSchool(student.getSchool());
		u.setUsedName(student.getUsedName());
		u.setCid(UUID.randomUUID().toString());
		u.setTclass(classDao.get(Tclass.class, student.getClassIds()));
		u.setUserId(student.getUserId());
		studentDao.save(u);
	}
	
	public boolean isUniqueUser(String userName, String id) {
		Tstudent tu = null;
		if (id == null) {
			tu = this.studentDao.get("from Tstudent t where t.code = ?", new String[] { userName });
			if (tu == null){
				return false;
			}
		}else{
			tu = this.studentDao.get("from Tstudent t where t.code = ?", new String[] { userName });
			if (tu == null){
				return false;
			}
			if(tu!=null&&tu.getCode().equals(id)){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public DataGrid datagrid(Student student) {
		DataGrid j = new DataGrid();
		j.setRows(this.changeModel(find(student)));
		j.setTotal(this.total(student));
		return j;
	}
	
	private Long total(Student user) {
		String hql = "select count(*) from Tstudent t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		values.add(user.getClassIds());
		hql = addWhere(user, hql, values);
		return studentDao.count(hql, values);
	}
	
	private List<Tstudent> find(Student student) {
		String hql = "from Tstudent t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(student, hql, values);
		values.add(student.getClassIds());
		return studentDao.find(hql, values, student.getPage(), student.getRows());
	}
	
	private String addWhere(Student user, String hql, List<Object> values) {
		hql += " and t.tclass.cid = ? ";
		return hql;
	}
	
	private List<Student> changeModel(List<Tstudent> tusers) {
		List<Student> users = new ArrayList<Student>();
		if (tusers != null && tusers.size() > 0) {
			for (Tstudent student : tusers) {
				Student u = new Student();
				u.setAddress(student.getAddress());
				u.setBirthday(student.getBirthday());
				u.setCode(student.getCode());
				u.setFatherMobile(student.getFatherMobile());
				u.setFatherName(student.getFatherName());
				u.setGender(student.getGender());
				u.setMotherMobile(student.getMotherMobile());
				u.setMotherName(student.getMotherName());
				u.setName(student.getName());
				u.setOtherConnect(student.getOtherConnect());
				u.setOtherConnectMobile(student.getOtherConnectMobile());
				u.setPy(student.getPy());
				u.setSchool(student.getSchool());
				u.setUsedName(student.getUsedName());
				u.setCid(student.getCid());
				u.setClassIds(student.getTclass().getCid());
				users.add(u);
				
			}
		}
		return users;
	}
	
	@Override
	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Tstudent u = studentDao.get(Tstudent.class, id.trim());
					if (u != null) {
						studentDao.delete(u);
					}
				}
			}
		}

	}

	@Override
	public void update(Student student) {
		Tstudent u = studentDao.get(Tstudent.class, student.getCid());
		u.setAddress(student.getAddress());
		u.setBirthday(student.getBirthday());
		u.setCode(student.getCode());
		u.setFatherMobile(student.getFatherMobile());
		u.setFatherName(student.getFatherName());
		u.setGender(student.getGender());
		u.setMotherMobile(student.getMotherMobile());
		u.setMotherName(student.getMotherName());
		u.setName(student.getName());
		u.setOtherConnect(student.getOtherConnect());
		u.setOtherConnectMobile(student.getOtherConnectMobile());
		u.setPy(student.getPy());
		u.setSchool(student.getSchool());
		u.setUsedName(student.getUsedName());
		u.setCid(student.getCid());
		u.setTclass(classDao.get(Tclass.class, student.getClassIds()));
		studentDao.save(u);

	}

	@Override
	public void classEdit(Student student) {
		// TODO Auto-generated method stub

	}

}
