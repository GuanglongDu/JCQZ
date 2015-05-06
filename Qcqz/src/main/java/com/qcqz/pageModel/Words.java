package com.qcqz.pageModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.qcqz.domain.Tpic;

public class Words implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int page;// 当前页
	private int rows;// 每页显示记录数
	private String sort;// 排序字段名
	private String order;// 按什么排序(asc,desc)
	private String cid;
	private String cdesc;
	private String cname;
	private String cpath;
	private String picNo;
	private String groupId;
	private Tpic tpic;
	private String wcnumber;
	private String pinyi;
	private String cterm;
	private BigDecimal cseq;
	private String letterIds;
	private Property property;
	private Categority category;
	private String categoryId;
	private List<Letter> letters = new ArrayList<Letter>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpath() {
		return cpath;
	}
	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	public String getPicNo() {
		return picNo;
	}
	public void setPicNo(String picNo) {
		this.picNo = picNo;
	}
	public Tpic getTpic() {
		return tpic;
	}
	public void setTpic(Tpic tpic) {
		this.tpic = tpic;
	}
	public String getWcnumber() {
		return wcnumber;
	}
	public void setWcnumber(String wcnumber) {
		this.wcnumber = wcnumber;
	}
	public String getPinyi() {
		return pinyi;
	}
	public void setPinyi(String pinyi) {
		this.pinyi = pinyi;
	}
	public String getCterm() {
		return cterm;
	}
	public void setCterm(String cterm) {
		this.cterm = cterm;
	}
	public BigDecimal getCseq() {
		return cseq;
	}
	public void setCseq(BigDecimal cseq) {
		this.cseq = cseq;
	}
	public String getLetterIds() {
		return letterIds;
	}
	public void setLetterIds(String letterIds) {
		this.letterIds = letterIds;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public List<Letter> getLetters() {
		return letters;
	}
	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public Categority getCategory() {
		return category;
	}
	public void setCategory(Categority category) {
		this.category = category;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	
}
