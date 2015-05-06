package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TcategoriesDAO;
import com.qcqz.domain.Tcategories;
import com.qcqz.pageModel.Categority;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.service.CategoriesService;
@Service
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	private TcategoriesDAO categoriesDao;
	@Override
	public void save(Categority categority) {
		Tcategories tcategories = new Tcategories();
		if (isUniqueName(tcategories.getCname(), null)){
			
		}
		tcategories.setCname(categority.getCname());
		tcategories.setCdesc(categority.getCdesc());
		tcategories.setCseq(categority.getCseq());
		tcategories.setCid(UUID.randomUUID().toString());
		categoriesDao.save(tcategories);
	}
	
	public boolean isUniqueName(String userName, String id) {
		Tcategories tcategories =  this.categoriesDao.get("from Tcategories t where t.cname = ?", new String[] { userName });
		if (tcategories == null){
			return false;
		}
		return true;
	}
	
	@Override
	public DataGrid datagrid(Categority categority) {
		DataGrid j = new DataGrid();
		j.setRows(this.changeModel(find(categority)));
		j.setTotal(this.total(categority));
		return j;
	}
	
	private List<Categority> changeModel(List<Tcategories> tusers) {
		List<Categority> users = new ArrayList<Categority>();
		if (tusers != null && tusers.size() > 0) {
			for (Tcategories tu : tusers) {
				Categority u = new Categority();
				u.setCdesc(tu.getCdesc());
				u.setCid(tu.getCid());
				u.setCname(tu.getCname());
				u.setCseq(tu.getCseq());
				users.add(u);
			}
		}
		return users;
	}
	
	private Long total(Categority user) {
		String hql = "select count(*) from Tcategories t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		//hql = addWhere(user, hql, values);
		return categoriesDao.count(hql, values);
	}
	private List<Tcategories> find(Categority user) {
		String hql = "from Tcategories t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		//hql = addWhere(user, hql, values);

//		if (user.getSort() != null && user.getOrder() != null) {
//			hql += " order by " + user.getSort() + " " + user.getOrder();
//		}
		return categoriesDao.find(hql, values, user.getPage(), user.getRows());
	}
	
	
	@Override
	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Tcategories u = categoriesDao.get(Tcategories.class, id.trim());
					if (u != null) {
						categoriesDao.delete(u);
					}
				}
			}
		}
	}

	@Override
	public void update(Categority categority) {
		if (isUniqueName(categority.getCname(), categority.getCid())) {
			String exception = "用户名已存在,请重新输入. ";
		}
		Tcategories u = categoriesDao.get(Tcategories.class, categority.getCid());
		
		if(categority.getCname()!=null&&!"".equals(categority.getCname())){
			u.setCname(categority.getCname());
		}
		if(categority.getCdesc()!=null&&!"".equals(categority.getCdesc())){
			u.setCdesc(categority.getCdesc());
		}
		if(categority.getCseq()!=null&&!"".equals(categority.getCseq())){
			u.setCseq(categority.getCseq());
		}
		categoriesDao.save(u);
	}

	@Override
	public List<Categority> combobox() {
		List<Categority> rl = new ArrayList<Categority>();
		List<Tcategories> l = categoriesDao.find("from Tcategories");
		if (l != null && l.size() > 0) {
			for (Tcategories t : l) {
				Categority r = new Categority();
				r.setCid(t.getCid());
				r.setCname(t.getCname());
				rl.add(r);
			}
		}
		return rl;
	}

}
