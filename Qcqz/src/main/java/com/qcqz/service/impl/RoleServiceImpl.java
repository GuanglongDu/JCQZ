package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TauthDAO;
import com.qcqz.dao.TroleDAO;
import com.qcqz.dao.TroletauthDAO;
import com.qcqz.dao.TusertroleDAO;
import com.qcqz.domain.Tauth;
import com.qcqz.domain.Trole;
import com.qcqz.domain.Troletauth;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Role;
import com.qcqz.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TroleDAO roleDao;
	@Autowired
	private TauthDAO authDao;
	@Autowired
	private TroletauthDAO roleauthDao;
	@Autowired
	private TusertroleDAO userroleDao;
	
	public DataGrid datagrid(Role role) {
		DataGrid j = new DataGrid();
		j.setRows(changeModel(find(role)));
		j.setTotal(total(role));
		return j;
	}

	private List<Role> changeModel(List<Trole> troles) {
		List<Role> roles = new ArrayList<Role>();
		if (troles != null && troles.size() > 0) {
			for (Trole tu : troles) {
				Role u = new Role();
				BeanUtils.copyProperties(tu, u);

				Set<Troletauth> troletauths = tu.getTroletauths();
				String authIds = "";
				String authNames = "";
				boolean b = false;
				if (troletauths != null && troletauths.size() > 0) {
					for (Troletauth troletauth : troletauths) {
						if (troletauth.getTauth() != null) {
							if (b) {
								authIds += ",";
								authNames += ",";
							}
							authIds += troletauth.getTauth().getCid();
							authNames += troletauth.getTauth().getCname();
							b = true;
						}
					}
				}
				u.setAuthIds(authIds);
				u.setAuthNames(authNames);

				roles.add(u);
			}
		}
		return roles;
	}

	private List<Trole> find(Role role) {
		String hql = "from Trole t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(role, hql, values);

		if (role.getSort() != null && role.getOrder() != null) {
			hql += " order by " + role.getSort() + " " + role.getOrder();
		}
		return roleDao.find(hql, values, role.getPage(), role.getRows());
	}

	private Long total(Role role) {
		String hql = "select count(*) from Trole t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(role, hql, values);
		return roleDao.count(hql, values);
	}

	private String addWhere(Role role, String hql, List<Object> values) {
		return hql;
	}

	public void add(Role role) {
		Trole r = new Trole();
		BeanUtils.copyProperties(role, r);
		r.setCid(UUID.randomUUID().toString());
		roleDao.save(r);

		this.saveRoleAuth(role, r);
	}

	/**
	 * 保存Trole和Tauth的关系
	 * 
	 * @param role
	 * @param r
	 */
	private void saveRoleAuth(Role role, Trole r) {
		roleauthDao.executeHql("delete Troletauth t where t.trole = ?", new Object[] { r });
		if (role.getAuthIds() != null) {
			for (String id : role.getAuthIds().split(",")) {
				Troletauth troletauth = new Troletauth();
				troletauth.setCid(UUID.randomUUID().toString());
				troletauth.setTauth(authDao.get(Tauth.class, id.trim()));
				troletauth.setTrole(r);
				roleauthDao.save(troletauth);
			}
		}
	}

	public void edit(Role role) {
		Trole r = roleDao.get(Trole.class, role.getCid());
		BeanUtils.copyProperties(role, r, new String[] { "cid" });

		this.saveRoleAuth(role, r);
	}

	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				Trole r = roleDao.get(Trole.class, id.trim());
				if (r != null) {
					roleauthDao.executeHql("delete Troletauth t where t.trole = ?", new Object[] { r });
					userroleDao.executeHql("delete Tusertrole t where t.trole = ?", new Object[] { r });
					roleDao.delete(r);
				}
			}
		}
	}

	public List<Role> combobox() {
		List<Role> rl = new ArrayList<Role>();
		List<Trole> l = roleDao.find("from Trole");
		if (l != null && l.size() > 0) {
			for (Trole t : l) {
				Role r = new Role();
				r.setCid(t.getCid());
				r.setCname(t.getCname());
				rl.add(r);
			}
		}
		return rl;
	}
}
