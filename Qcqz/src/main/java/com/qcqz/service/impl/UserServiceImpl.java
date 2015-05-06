package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TdeptDAO;
import com.qcqz.dao.TroleDAO;
import com.qcqz.dao.TuserDAO;
import com.qcqz.dao.TusertroleDAO;
import com.qcqz.domain.Tauth;
import com.qcqz.domain.Tdept;
import com.qcqz.domain.Tmenu;
import com.qcqz.domain.Trole;
import com.qcqz.domain.Troletauth;
import com.qcqz.domain.Tuser;
import com.qcqz.domain.Tusertrole;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.TreeNode;
import com.qcqz.pageModel.User;
import com.qcqz.service.UserService;
import com.qcqz.util.AuthComparator;
import com.qcqz.util.Encrypt;
import com.qcqz.util.MenuComparator;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TuserDAO userDao;
	@Autowired
	private TroleDAO roleDao;
	@Autowired
	private TdeptDAO deptDao;
	@Autowired
	private TusertroleDAO userroleDao;
	
	public User login(User user) {
		Tuser t = userDao.get("from Tuser t where t.cname = ? and t.cpwd = ?", new Object[] { user.getCname(), Encrypt.e(user.getCpwd()) });
		if (t != null) {
			user.setCid(t.getCid());
			user.setCname(t.getCname());
			user.setCemail(t.getCemail());
			user.setCrealname(t.getCrealname());
			user.setCcreatedatetime(t.getCcreatedatetime());
			user.setCmodifydatetime(t.getCmodifydatetime());
			user.setCstatus(t.getCstatus());

			Map<String, String> authIdsMap = new HashMap<String, String>();
			String authIds = "";
			String authNames = "";
			Map<String, String> authUrlsMap = new HashMap<String, String>();
			String authUrls = "";
			String roleIds = "";
			String roleNames = "";
			boolean b1 = false;
			Set<Tusertrole> tusertroles = t.getTusertroles();
			List<TreeNode> tree = new ArrayList<TreeNode>();
			if (tusertroles != null && tusertroles.size() > 0) {
				for (Tusertrole tusertrole : tusertroles) {
					Trole trole = tusertrole.getTrole();
					if (b1) {
						roleIds += ",";
						roleNames += ",";
					}
					roleIds += trole.getCid();
					roleNames += trole.getCname();
					b1 = true;
					
					Set<Troletauth> troletauths = trole.getTroletauths();
					if (troletauths != null && troletauths.size() > 0) {
						for (Troletauth troletauth : troletauths) {
							Tauth tauth = troletauth.getTauth();
							tree.add(tree(tauth, true));
							authIdsMap.put(tauth.getCid(), tauth.getCname());
							authUrlsMap.put(tauth.getCid(), tauth.getCurl());
						}
					}
				}
			}
			boolean b2 = false;
			for (String id : authIdsMap.keySet()) {
				if (b2) {
					authIds += ",";
					authNames += ",";
				}
				authIds += id;
				authNames += authIdsMap.get(id);
				b2 = true;
			}
			user.setAuthIds(authIds);
			user.setAuthNames(authNames);
			user.setRoleIds(roleIds);
			user.setRoleNames(roleNames);
			boolean b3 = false;
			for (String id : authUrlsMap.keySet()) {
				if (b3) {
					authUrls += ",";
				}
				authUrls += authUrlsMap.get(id);
				b3 = true;
			}
			user.setAuthUrls(authUrls);

			return user;
		}
		return null;
	}

	private TreeNode tree(Tauth t, boolean recursive) {
		TreeNode node = new TreeNode();
		node.setId(t.getCid());
		node.setText(t.getCname());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("url", t.getCurl());
		node.setAttributes(attributes);
		if (t.getCiconcls() != null) {
			node.setIconCls(t.getCiconcls());
		} else {
			node.setIconCls("");
		}
		if (t.getTauths() != null && t.getTauths().size() > 0) {
			node.setState("closed");
			if (recursive) {// 递归查询子节点
				List<Tauth> l = new ArrayList<Tauth>(t.getTauths());
				Collections.sort(l, new AuthComparator());// 排序
				List<TreeNode> children = new ArrayList<TreeNode>();
				for (Tauth r : l) {
					TreeNode tn = tree(r, true);
					children.add(tn);
				}
				node.setChildren(children);
				node.setState("open");
			}
		}
		return node;
	}

	
	public List<TreeNode> getUserMenu(String userId){
		List<TreeNode> tree = new ArrayList<TreeNode>();
		Tuser user = userDao.get("from Tuser t where t.cid = ?",new Object[]{userId});
		if(user != null){
			Set<Tusertrole> tusertroles = user.getTusertroles();
			if (tusertroles != null && tusertroles.size() > 0) {
				for (Tusertrole tusertrole : tusertroles) {
					Trole trole = tusertrole.getTrole();
					Set<Troletauth> troletauths = trole.getTroletauths();
					if (troletauths != null && troletauths.size() > 0) {
						for (Troletauth troletauth : troletauths) {
							Tauth tauth = troletauth.getTauth();
							if(tauth.getTauths().size()>0)
							tree.add(this.tree(tauth, true));
						}
					}
				}
			}
		}
		return tree;
	}
	
	public void save(User user) {
		Tuser u = new Tuser();
		if (isUniqueUser(user.getCname(), null)) {
			String exception = "用户名已存在,请重新输入. ";
		}
		u.setCname(user.getCname());
		u.setCemail(user.getCemail());
		u.setCrealname(user.getCrealname());
		u.setCstatus(user.getCstatus());

		u.setCid(UUID.randomUUID().toString());
		if (user.getCcreatedatetime() == null) {
			u.setCcreatedatetime(new Date());
		}
		if (user.getCmodifydatetime() == null) {
			u.setCmodifydatetime(new Date());
		}
		u.setCpwd(Encrypt.e(user.getCpwd()));
		
		u.setTdept(deptDao.get(Tdept.class, user.getDeptId()));
		userDao.save(u);

		this.saveUserRole(user, u);
	}

	/**
	 * 保存用户和角色的关系
	 * 
	 * @param user
	 * @param u
	 */
	private void saveUserRole(User user, Tuser u) {
		userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
		if (user.getRoleIds() != null) {
			for (String id : user.getRoleIds().split(",")) {
				Tusertrole tusertrole = new Tusertrole();
				tusertrole.setCid(UUID.randomUUID().toString());
				tusertrole.setTrole(roleDao.get(Trole.class, id.trim()));
				tusertrole.setTuser(u);
				userroleDao.save(tusertrole);
			}
		}
	}

	public void update(User user)  {
		if (isUniqueUser(user.getCname(), user.getCid())) {
			String exception = "用户名已存在,请重新输入. ";
		}
		Tuser u = userDao.get(Tuser.class, user.getCid());
		
		if(user.getCname()!=null&&!"".equals(user.getCname())){
			u.setCname(user.getCname());
		}
		if(user.getCemail()!=null&&!"".equals(user.getCemail())){
			u.setCemail(user.getCemail());
		}
		if(user.getCrealname()!=null&&!"".equals(user.getCrealname())){
			u.setCrealname(user.getCrealname());
		}
		if(user.getDeptId()!=null&&!"".equals(user.getDeptId())){
			u.setTdept(deptDao.get(Tdept.class, user.getDeptId()));
		}
		if(user.getCstatus()!=null&&!"".equals(user.getCstatus())){
			u.setCstatus(user.getCstatus());
		}
		if (user.getCmodifydatetime() == null) {
			u.setCmodifydatetime(new Date());
		}
		if (user.getCpwd() != null && !user.getCpwd().trim().equals("")) {
			u.setCpwd(Encrypt.e(user.getCpwd()));
		}
		this.saveUserRole(user, u);
	}

	/**
	 * 判断用户名是否唯一
	 * 
	 * @param user
	 * @param u
	 */
	public boolean isUniqueUser(String userName, String id) {
		Tuser tu = null;
		if (id == null) {
			tu = this.userDao.get("from Tuser t where t.cname = ?", new String[] { userName });
			if (tu == null){
				return false;
			}
		}else{
			tu = this.userDao.get("from Tuser t where t.cname = ?", new String[] { userName });
			if (tu == null){
				return false;
			}
			if(tu!=null&&tu.getCid().equals(id)){
				return false;
			}
		}
		return true;
	}
	
	public DataGrid datagrid(User user) {
		DataGrid j = new DataGrid();
		j.setRows(this.changeModel(find(user)));
		j.setTotal(this.total(user));
		return j;
	}

	private List<User> changeModel(List<Tuser> tusers) {
		List<User> users = new ArrayList<User>();
		if (tusers != null && tusers.size() > 0) {
			for (Tuser tu : tusers) {
				User u = new User();
				u.setCsn(tu.getCsn());
				u.setCid(tu.getCid());
				u.setCname(tu.getCname());
				u.setCemail(tu.getCemail());
				u.setCrealname(tu.getCrealname());
				u.setCcreatedatetime(tu.getCcreatedatetime());
				u.setCmodifydatetime(tu.getCmodifydatetime());
				u.setCstatus(tu.getCstatus());
				
				u.setDeptId(tu.getTdept().getCid());
				u.setDeptName(tu.getTdept().getCname());

				Set<Tusertrole> tusertroles = tu.getTusertroles();
				String roleIds = "";
				String roleNames = "";
				boolean b = false;
				if (tusertroles != null && tusertroles.size() > 0) {
					for (Tusertrole tusertrole : tusertroles) {
						if (tusertrole.getTrole() != null) {
							if (b) {
								roleIds += ",";
								roleNames += ",";
							}
							roleIds += tusertrole.getTrole().getCid();
							roleNames += tusertrole.getTrole().getCname();
							b = true;
						}
					}
				}
				u.setRoleIds(roleIds);
				u.setRoleNames(roleNames);

				users.add(u);
			}
		}
		return users;
	}

	private List<Tuser> find(User user) {
		String hql = "from Tuser t where 1=1 ";

		List<Object> values = new ArrayList<Object>();
		hql = addWhere(user, hql, values);

		if (user.getSort() != null && user.getOrder() != null) {
			hql += " order by " + user.getSort() + " " + user.getOrder();
		}
		return userDao.find(hql, values, user.getPage(), user.getRows());
	}

	private Long total(User user) {
		String hql = "select count(*) from Tuser t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(user, hql, values);
		return userDao.count(hql, values);
	}

	private String addWhere(User user, String hql, List<Object> values) {
		if (user.getCname() != null && !user.getCname().trim().equals("")) {
			hql += " and t.cname like ? ";
			values.add("%%" + user.getCname().trim() + "%%");
		}
		if (user.getCcreatedatetimeStart() != null) {
			hql += " and t.ccreatedatetime>=? ";
			values.add(user.getCcreatedatetimeStart());
		}
		if (user.getCcreatedatetimeEnd() != null) {
			hql += " and t.ccreatedatetime<=? ";
			values.add(user.getCcreatedatetimeEnd());
		}
		if (user.getCmodifydatetimeStart() != null) {
			hql += " and t.cmodifydatetime>=? ";
			values.add(user.getCmodifydatetimeStart());
		}
		if (user.getCmodifydatetimeEnd() != null) {
			hql += " and t.cmodifydatetime<=? ";
			values.add(user.getCmodifydatetimeEnd());
		}
		return hql;
	}

	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Tuser u = userDao.get(Tuser.class, id.trim());
					if (u != null) {
						userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						userDao.delete(u);
					}
				}
			}
		}
	}

	public void roleEdit(User user) {
		if (user.getIds() != null) {
			for (String id : user.getIds().split(",")) {
				Tuser u = userDao.get(Tuser.class, id);
				this.saveUserRole(user, u);
			}
		}
	}

	public void editUserInfo(User user) {
		if (user.getCpwd() != null && !user.getCpwd().trim().equals("")) {
			Tuser t = userDao.get(Tuser.class, user.getCid());
			t.setCpwd(Encrypt.e(user.getCpwd()));
		}
	}
}
