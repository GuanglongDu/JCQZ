package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TclassDAO;
import com.qcqz.domain.Tclass;
import com.qcqz.pageModel.TreeNode;
import com.qcqz.pageModel.UserClass;
import com.qcqz.service.ClassService;
import com.qcqz.util.ClassComparator;
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private TclassDAO classDao;
	@Override
	public List<UserClass> findAll() {
		List<UserClass> ld = new ArrayList<UserClass>();
		String hql = "from Tclass t order by t.cseq";
		List<Tclass> ltd = classDao.find(hql);
		for (Tclass td : ltd) {
			UserClass d = new UserClass();
			d.setCid(td.getCid());
			d.setCname(td.getCname());
			d.setCiconcls(td.getCiconcls());
			if(td.getTclass()!=null){
				d.setPid(td.getTclass().getCid());
			}
			ld.add(d);
		}
		return ld;
	}

	@Override
	public List<UserClass> treegrid(UserClass property) {
		List<Tclass> l;
		if (property != null && property.getId() != null) {
			l = classDao.find("from Tclass t where t.tclass.cid = ? order by t.cseq", new Object[] { property.getId() });
		} else {
			l = classDao.find("from Tclass t where t.tclass is null order by t.cseq");
		}
		return changeModel(l);
	}

	@Override
	public void delete(UserClass property) {
		del(property.getCid());

	}

	private void del(String cid) {
		Tclass t = classDao.get(Tclass.class, cid);
		if (t != null) {
			Set<Tclass> depts = t.getTclasses();
			if (depts != null && !depts.isEmpty()) {
				for (Tclass tdept : depts) {
					del(tdept.getCid());
				}
			}
			classDao.delete(t);
		}
	}

	@Override
	public void add(UserClass property) {
		Tclass t = new Tclass();
		BeanUtils.copyProperties(property, t);
		t.setCid(UUID.randomUUID().toString());
		if (property.getPid() != null) {
			t.setTclass(classDao.get(Tclass.class, property.getPid()));
		}
		if (property.getIconCls() != null) {
			t.setCiconcls(property.getIconCls());
		}
		classDao.save(t);
	}

	@Override
	public void edit(UserClass property) {
		Tclass t = classDao.get(Tclass.class, property.getCid());
		BeanUtils.copyProperties(property, t);
		if (property.getIconCls() != null) {
			t.setCiconcls(property.getIconCls());
		}
		if (property.getPid() != null && !property.getPid().equals(property.getCid())) {
			Tclass pt = classDao.get(Tclass.class, property.getPid());
			if (pt != null) {
				if (isDown(t, pt)) {// 要将当前节点修改到当前节点的子节点中
					Set<Tclass> tdepts = t.getTclasses();// 当前要修改的节点的所有下级节点
					if (tdepts != null && tdepts.size() > 0) {
						for (Tclass tdept : tdepts) {
							if (tdept != null) {
								tdept.setTclass(null);
							}
						}
					}
				}
				t.setTclass(pt);
			}
		}
	}
	
	private boolean isDown(Tclass t, Tclass pt) {
		if (pt.getTclass() != null) {
			if (pt.getTclass().getCid().equals(t.getCid())) {
				return true;
			} else {
				return isDown(t, pt.getTclass());
			}
		}
		return false;
	}

	@Override
	public List<TreeNode> tree(UserClass property, Boolean b) {
		List<Object> param = new ArrayList<Object>();
		String hql = "from Tclass t where t.tclass is null order by t.cseq";
		if (property != null && property.getId() != null && !property.getId().trim().equals("")) {
			hql = "from Tclass t where t.tclass.cid = ? order by t.cseq";
			param.add(property.getId());
		}
		List<Tclass> l = classDao.find(hql, param);
		List<TreeNode> tree = new ArrayList<TreeNode>();
		for (Tclass t : l) {
			tree.add(this.tree(t, b));
		}
		return tree;
	}
	
	private TreeNode tree(Tclass t, boolean recursive) {
		TreeNode node = new TreeNode();
		node.setId(t.getCid());
		node.setText(t.getCname());
		if (t.getCiconcls() != null) {
			node.setIconCls(t.getCiconcls());
		} else {
			node.setIconCls("");
		}
		if (t.getTclasses() != null && t.getTclasses().size() > 0) {
			node.setState("closed");
			if (recursive) {// 递归查询子节点
				List<Tclass> l = new ArrayList<Tclass>(t.getTclasses());
				Collections.sort(l, new ClassComparator());
				List<TreeNode> children = new ArrayList<TreeNode>();
				for (Tclass r : l) {
					TreeNode tn = tree(r, true);
					children.add(tn);
				}
				node.setChildren(children);
				node.setState("open");
			}
		}
		return node;
	}
	
	private List<UserClass> changeModel(List<Tclass> property) {
		List<UserClass> l = new ArrayList<UserClass>();
		if (property != null && property.size() > 0) {
			for (Tclass t : property) {
				UserClass m = new UserClass();
				BeanUtils.copyProperties(t, m);
				if (t.getTclass() != null) {
					m.setPid(t.getTclass().getCid());
					m.setPname(t.getTclass().getCname());
				}
				if (countChildren(t.getCid()) > 0) {
					m.setState("closed");
				}
				if (t.getCiconcls() == null) {
					m.setIconCls("");
				} else {
					m.setIconCls(t.getCiconcls());
				}
				l.add(m);
			}
		}
		return l;
	}
	
	private Long countChildren(String pid) {
		return classDao.count("select count(*) from Tclass t where t.tclass.cid = ?", new Object[] { pid });
	}

}
