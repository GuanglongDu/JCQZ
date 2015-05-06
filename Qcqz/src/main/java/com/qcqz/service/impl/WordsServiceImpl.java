package com.qcqz.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcqz.dao.TWordslettersDAO;
import com.qcqz.dao.TcategoriesDAO;
import com.qcqz.dao.TgrouplettersDAO;
import com.qcqz.dao.TletterDAO;
import com.qcqz.dao.TpropertyDAO;
import com.qcqz.dao.TwordsDAO;
import com.qcqz.domain.Tcategories;
import com.qcqz.domain.Tgroupletters;
import com.qcqz.domain.Tletter;
import com.qcqz.domain.Tproperty;
import com.qcqz.domain.Twordletters;
import com.qcqz.domain.Twords;
import com.qcqz.pageModel.Categority;
import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Letter;
import com.qcqz.pageModel.Property;
import com.qcqz.pageModel.TreeNode;
import com.qcqz.pageModel.Words;
import com.qcqz.service.WordService;
import com.qcqz.util.PropertiesComparator;
@Service
public class WordsServiceImpl implements WordService {
	@Autowired
	private TwordsDAO wordsDao;
	@Autowired
	private TWordslettersDAO wordLettersDao;
	@Autowired
	private TletterDAO letterDao;
	@Autowired
	private TpropertyDAO propertyDao;
	@Autowired
	private TgrouplettersDAO  grouplettersDao;
	@Autowired
	private TcategoriesDAO tcategoriesDao;
	@Override
	public void add(Words words) {
		Twords tword = new Twords();
		tword.setCname(words.getCname());
		tword.setCdesc(words.getCdesc());
		tword.setCpath(words.getCpath());
		tword.setWcnumber(words.getWcnumber());
		tword.setCseq(words.getCseq());
		tword.setCterm(words.getCterm());
		tword.setCid(UUID.randomUUID().toString());
		tword.setPinyi(words.getPinyi());

		Tcategories tcategories = tcategoriesDao.get(Tcategories.class, words.getCategoryId());
		tword.setTcategories(tcategories);
		Tproperty tgroup = propertyDao.get(Tproperty.class, words.getGroupId());
		tword.setTproperty(tgroup);
		List<Letter> letters = words.getLetters();
		for(Letter letter:letters){
			Tletter tletter = findTletter(letter);
			if(tletter != null){
				Twordletters wordLetter = new Twordletters();
				wordLetter.setCid(UUID.randomUUID().toString());
				wordLetter.setTletter(tletter);
				wordLetter.setTwords(tword);
				wordLetter.setCseq(letter.getCseq());
				wordLettersDao.save(wordLetter);
				Tgroupletters groupletters = new Tgroupletters();
				groupletters.setCid(UUID.randomUUID().toString());
				groupletters.setTproperty(tgroup);
				groupletters.setTletter(tletter);
				groupletters.setCseq(letter.getCseq());
				grouplettersDao.save(groupletters);
			}
		}
		wordsDao.save(tword);
	}

	
	public Tletter findTletter(Letter letter){
		String character = letter.getCname();
		String pinyin = letter.getPinyin();
		Tletter find = letterDao.get("from Tletter t where t.cname = ? and t.pinyin = ?", new String[] {character,pinyin});
		return find;
	}
	
	@Override
	public void update(Words words) {
		Twords u = wordsDao.get(Twords.class, words.getCid());
		if(words.getCname()!=null&&!"".equals(words.getCname())){
			u.setCname(words.getCname());
		}
		if(words.getCdesc()!=null&&!"".equals(words.getCdesc())){
			u.setCdesc(words.getCdesc());
		}
		if(words.getCpath()!=null&&!"".equals(words.getCpath())){
			u.setCpath(words.getCpath());
		}
		if(words.getWcnumber()!=null&&!"".equals(words.getWcnumber())){
			u.setWcnumber(words.getWcnumber());
		}
		if(words.getCseq()!=null&&!"".equals(words.getCseq())){
			u.setCseq(words.getCseq());
		}
		Tproperty tgroup = propertyDao.get(Tproperty.class, words.getGroupId());
		List<Letter> letters = words.getLetters();
		for(Letter letter:letters){
			Tletter tletter = findTletter(letter);
			if(tletter != null){
				Twordletters wordLetter = new Twordletters();
				wordLetter.setCid(UUID.randomUUID().toString());
				wordLetter.setTletter(tletter);
				wordLetter.setTwords(u);
				wordLettersDao.save(wordLetter);
				Tgroupletters groupletters = new Tgroupletters();
				groupletters.setCid(UUID.randomUUID().toString());
				groupletters.setTproperty(tgroup);
				groupletters.setTletter(tletter);
				grouplettersDao.save(groupletters);
			}
		}
		wordsDao.update(u);
	}
	
	private void saveWordsLetter(Words user, Twords u) {
		wordLettersDao.executeHql("delete Twordletters t where t.twords = ?", new Object[] { u });
		if (user.getLetterIds() != null) {
			for (String id : user.getLetterIds().split(",")) {
				Twordletters tusertrole = new Twordletters();
				tusertrole.setCid(UUID.randomUUID().toString());
				tusertrole.setTletter(letterDao.get(Tletter.class, id.trim()));
				tusertrole.setTwords(u);
				wordLettersDao.save(tusertrole);
			}
		}
	}
	
	@Override
	public void delete(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Twords u = wordsDao.get(Twords.class, id.trim());
					if (u != null) {
						wordLettersDao.executeHql("delete Twordletters t where t.twords = ?", new Object[] { u });
						grouplettersDao.executeHql("delete Tgroupletters t where t.tproperty = ?",new Object[] { u.getTproperty() });
						wordsDao.delete(u);
						
					}
				}
			}
		}
	}

	@Override
	public DataGrid datagrid(Words words) {
		DataGrid j = new DataGrid();
		j.setRows(this.changeModel(find(words)));
		j.setTotal(this.total(words));
		return j;
	}
	
	private List<Words> changeModel(List<Twords> tusers) {
		List<Words> users = new ArrayList<Words>();
		if (tusers != null && tusers.size() > 0) {
			for (Twords student : tusers) {
				Words u = new Words();
				u.setCid(student.getCid());
				u.setCname(student.getCname());
				u.setCpath(student.getCpath());
				u.setPinyi(student.getPinyi());
				u.setWcnumber(student.getWcnumber());
				Tproperty tproperty = student.getTproperty();
				if(tproperty != null){
					Property property = new Property();
					property.setCid(tproperty.getCid());
					property.setCname(tproperty.getCname());
					u.setProperty(property);
				}
				Tcategories tcategories = student.getTcategories();
				if(tcategories != null){
					Categority cate = new Categority();
					cate.setCid(tcategories.getCid());
					cate.setCname(tcategories.getCname());
					u.setCategory(cate);
				}
				List<Letter> letters = new ArrayList<Letter>();
				Set twordletters = student.getTwordletters();
				Iterator iterator = twordletters.iterator();
				while(iterator.hasNext()){
					Twordletters wordletters = (Twordletters) iterator.next();
					Tletter tletter = wordletters.getTletter();
					Letter letter = new Letter();
					letter.setCid(tletter.getCid());
					letter.setCname(tletter.getCname());
					letter.setPinyin(tletter.getPinyin());
					letter.setCpath(tletter.getCpath());
					letter.setCseq(tletter.getCseq());
					letters.add(letter);
				}
				u.setLetters(letters);
				users.add(u);
			}
		}
		return users;
	}
	private List<Twords> find(Words student) {
		String groupHql = "from Tproperty t where t.cid =?";
		Tproperty find = propertyDao.get(groupHql, new String[]{student.getGroupId()});
		List<Object> values = new ArrayList<Object>();
//		for(Tproperty group:find){
//			values.add(group.getCid());
//		}
		findGroupProperty(find,values);
		String hql = "from Twords t where 1=1 ";

		hql = addWhere(student, hql, values);
		
		return wordsDao.find(hql, values, student.getPage(), student.getRows());
	}
	
	private void findGroupProperty(Tproperty find,List<Object> values){
		if (find != null && find.getCiconcls() != null) {
			if (find.getCiconcls().equals("4")) {
				values.add(find.getCid());
			} else {
				String groupHql = "from Tproperty t where t.tproperty.cid = ?";
				List<Tproperty> list = propertyDao.find(groupHql,new Object[] { find.getCid() });
				for (Tproperty t : list) {
					findGroupProperty(t, values);
				}
			}
		}
	}
	
	private Long total(Words user) {
		String hql = "select count(*) from Twords t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		if(user.getGroupId() != null){
			String groupHql = "from Tproperty t where t.cid =?";
			Tproperty find = propertyDao.get(groupHql, new String[]{user.getGroupId()});
			findGroupProperty(find,values);
		}else{
			values.add(user.getGroupId());
		}
		hql = addWhere(user, hql, values);
		return wordsDao.count(hql, values);
	}
	
	private String addWhere(Words user, String hql, List<Object> values) {
		if(values.size()>0){
			hql += " and t.tproperty.cid = ? ";
			for(int i=1;i<values.size();i++){
				hql += "or t.tproperty.cid = ?";
			}
		}
		hql += " order by cseq";
		return hql;
	}


	@Override
	public DataGrid datagridCourse(Words words) {
		DataGrid j = new DataGrid();
		List<Words> list = this.changeModel(find(words));
		Collections.shuffle(list);
		j.setRows(list);
		j.setTotal(this.total(words));
		return j;
	}
	
	private TreeNode treeCourse(Tproperty t, boolean recursive) {
		TreeNode node = new TreeNode();
		node.setId(t.getCid());
		node.setText(t.getCname());
		if (t.getCiconcls() != null) {
			node.setIconCls(t.getCiconcls());
		} else {
			node.setIconCls("");
		}
		if (t.getTproperties() != null && t.getTproperties().size() > 0) {
			node.setState("closed");
			if (recursive) {
				List<Tproperty> l = new ArrayList<Tproperty>(t.getTproperties());
				Collections.sort(l, new PropertiesComparator());
				List<TreeNode> children = new ArrayList<TreeNode>();
				for (Tproperty r : l) {
						TreeNode tn = treeCourse(r, true);
						children.add(tn);
					}
				node.setChildren(children);
				node.setState("open");
			}
		}
		return node;
	}
}
