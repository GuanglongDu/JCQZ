package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qcqz.dao.TauthDAO;
import com.qcqz.domain.Tauth;
import com.qcqz.domain.Tmenu;
import com.qcqz.pageModel.Auth;
import com.qcqz.pageModel.TreeNode;
import com.qcqz.service.MenuService;
import com.qcqz.util.AuthComparator;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private TauthDAO menuDao;
	
	public List<Auth> findAll() {
		List<Auth> lm = new ArrayList<Auth>();
		String hql = "from Tauth t order by t.cseq";
		List<Tauth> ltm = menuDao.find(hql);
		for (Tauth tm : ltm) {
			Auth m = new Auth();
			m.setCid(tm.getCid());
			m.setCname(tm.getCname());
			m.setCiconcls(tm.getCiconcls());
			m.setCurl(tm.getCurl());
			if(tm.getTauth()!=null){
				m.setPid(tm.getTauth().getCid());
			}
			lm.add(m);
		}
		return lm;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<TreeNode> tree(Auth menu, Boolean b) {
		List<Object> param = new ArrayList<Object>();
		String hql = "from Tauth t where t.tmenu is null order by t.cseq";
		if (menu != null && menu.getId() != null && !menu.getId().trim().equals("")) {
			hql = "from Tauth t where t.tmenu.cid = ? order by t.cseq";
			param.add(menu.getId());
		}
		List<Tauth> l = menuDao.find(hql, param);
		List<TreeNode> tree = new ArrayList<TreeNode>();
		for (Tauth t : l) {
			tree.add(this.tree(t, b));
		}
		return tree;
	}
	
	@Override
	public List<TreeNode> treeByUserId(String authIds) {
		List<TreeNode> tree = new ArrayList<TreeNode>();
		for (String id : authIds.split(",")) {
			String hql = "from Tmenu t where t.tmenu.cid = ? order by t.cseq";
			List<Tauth> l = menuDao.find(hql, new Object[] { id });
			for (Tauth t : l) {
				tree.add(this.tree(t, true));
			}
		}
		return tree;
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
		if (t.getTauth() != null && t.getTauths().size() > 0) {
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

	public List<Auth> treegrid(Auth menu) {
		List<Tauth> l;
		if (menu != null && menu.getId() != null) {
			l = menuDao.find("from Tauth t where t.tmenu.cid = ? order by t.cseq", new Object[] { menu.getId() });
		} else {
			l = menuDao.find("from Tauth t where t.tmenu is null order by t.cseq");
		}
		return changeModel(l);
	}

	private List<Auth> changeModel(List<Tauth> Tmenus) {
		List<Auth> l = new ArrayList<Auth>();
		if (Tmenus != null && Tmenus.size() > 0) {
			for (Tauth t : Tmenus) {
				Auth m = new Auth();
				BeanUtils.copyProperties(t, m);
				if (t.getTauth() != null) {
					m.setPid(t.getTauth().getCid());
					m.setPname(t.getTauth().getCname());
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

	/**
	 * 统计有多少子节点
	 */
	private Long countChildren(String pid) {
		return menuDao.count("select count(*) from Tauth t where t.tmenu.cid = ?", new Object[] { pid });
	}

	public void delete(Auth menu) {
		del(menu.getCid());
	}

	private void del(String cid) {
		Tauth t = menuDao.get(Tauth.class, cid);
		if (t != null) {
			Set<Tauth> menus = t.getTauths();
			if (menus != null && !menus.isEmpty()) {
				// 说明当前菜单下面还有子菜单
				for (Tauth tmenu : menus) {
					del(tmenu.getCid());
				}
			}
			menuDao.delete(t);
		}
	}

	public void add(Auth menu) {
		Tauth t = new Tauth();
		BeanUtils.copyProperties(menu, t);
		t.setCid(UUID.randomUUID().toString());
		if (menu.getPid() != null) {
			t.setTauth(menuDao.get(Tauth.class, menu.getPid()));
		}
		if (menu.getIconCls() != null) {
			t.setCiconcls(menu.getIconCls());
		}
		menuDao.save(t);
	}

	public void edit(Auth menu) {
		Tauth t = menuDao.get(Tauth.class, menu.getCid());
		BeanUtils.copyProperties(menu, t);
		if (menu.getIconCls() != null) {
			t.setCiconcls(menu.getIconCls());
		}
		if (menu.getPid() != null && !menu.getPid().equals(menu.getCid())) {
			Tauth pt = menuDao.get(Tauth.class, menu.getPid());
			if (pt != null) {
				if (isDown(t, pt)) {// 要将当前节点修改到当前节点的子节点中
					Set<Tmenu> tmenus = t.getTauths();// 当前要修改的节点的所有下级节点
					if (tmenus != null && tmenus.size() > 0) {
						for (Tmenu tmenu : tmenus) {
							if (tmenu != null) {
								tmenu.setTmenu(null);
							}
						}
					}
				}
				t.setTauth(pt);
			}

		}
	}

	/**
	 * 判断是否是将当前节点修改到当前节点的子节点
	 * 
	 * @param t
	 * @param pt
	 * @return
	 */
	private boolean isDown(Tauth t, Tauth pt) {
		if (pt.getTauth() != null) {
			if (pt.getTauth().getCid().equals(t.getCid())) {
				return true;
			} else {
				return isDown(t, pt.getTauth());
			}
		}
		return false;
	}

	
}
