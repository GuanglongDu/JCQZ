package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TletterDAO;
import com.qcqz.domain.Tletter;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Letter;
import com.qcqz.service.LetterService;
@Service
public class LetterServiceImpl implements LetterService {

	@Autowired
	private TletterDAO letterDao;
	
	
	@Override
	public void save(Letter letter) {
		Tletter tletter = new Tletter();
		if (isUniqueName(tletter.getCname(), null)){
			
		}
		tletter.setCname(letter.getCname());
		tletter.setCdesc(letter.getCdesc());
		tletter.setCseq(letter.getCseq());
		tletter.setCpath(letter.getCpath());
		tletter.setPinyin(letter.getPinyin());
		tletter.setWcnumber(letter.getWcnumber());
		tletter.setCid(UUID.randomUUID().toString());
		letterDao.save(tletter);
		
	}
	public boolean isUniqueName(String userName, String id) {
		Tletter tcategories =  this.letterDao.get("from Tletter t where t.cname = ?", new String[] { userName });
		if (tcategories == null){
			return false;
		}
		return true;
	}
	
	@Override
	public DataGrid datagrid(Letter letter) {
		DataGrid j = new DataGrid();
		j.setRows(this.changeModel(find(letter)));
		j.setTotal(this.total(letter));
		return j;
	}
	
	private List<Letter> changeModel(List<Tletter> tusers) {
		List<Letter> users = new ArrayList<Letter>();
		if (tusers != null && tusers.size() > 0) {
			for (Tletter tu : tusers) {
				Letter u = new Letter();
				u.setCdesc(tu.getCdesc());
				u.setCid(tu.getCid());
				u.setCname(tu.getCname());
				u.setCseq(tu.getCseq());
				u.setCpath(tu.getCpath());
				u.setPinyin(tu.getPinyin());
				u.setCid(tu.getCid());
				users.add(u);
			}
		}
		return users;
	}
	
	private List<Tletter> find(Letter user) {
		String hql = "from Tletter t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		return letterDao.find(hql, values, user.getPage(), user.getRows());
	}
	
	private Long total(Letter user) {
		String hql = "select count(*) from Tletter t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		return letterDao.count(hql, values);
	}
	
	@Override
	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Tletter u = letterDao.get(Tletter.class, id.trim());
					if (u != null) {
						letterDao.delete(u);
					}
				}
			}
		}
		
	}

	@Override
	public void update(Letter letter) {
		if (isUniqueName(letter.getCname(), letter.getCid())) {
			String exception = "用户名已存在,请重新输入. ";
		}
		Tletter u = letterDao.get(Tletter.class, letter.getCid());
		
		if(letter.getCname()!=null&&!"".equals(letter.getCname())){
			u.setCname(letter.getCname());
		}
		if(letter.getCdesc()!=null&&!"".equals(letter.getCdesc())){
			u.setCdesc(letter.getCdesc());
		}
		if(letter.getCseq()!=null&&!"".equals(letter.getCseq())){
			u.setCseq(letter.getCseq());
		}
		if(letter.getCpath()!=null&&!"".equals(letter.getCpath())){
			u.setCpath(letter.getCpath());
		}
		if(letter.getPinyin()!=null&&!"".equals(letter.getPinyin())){
			u.setPinyin(letter.getPinyin());
		}
		if(letter.getWcnumber()!=null&&!"".equals(letter.getWcnumber())){
			u.setWcnumber(letter.getWcnumber());
		}
		letterDao.save(u);
	}

	@Override
	public void query(Letter letter) {
		
		
	}

	
}
