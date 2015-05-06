package com.qcqz.pageModel;

import java.util.Date;

import com.qcqz.domain.Tproperty;
import com.qcqz.domain.Tstudent;

public class Evalutative  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cid;
	private String mainpicture;
	private String assessment;
	private String classinfo;
	private Date createdate;
	private Tproperty tproperty;
	private Tstudent tstudent;
	private String propertyId;
	private String studentId;
	
	private int page;// 当前页
	private int rows;// 每页显示记录数
	private String sort;// 排序字段名
	private String order;// 按什么排序(asc,desc)
	
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
	public String getMainpicture() {
		return mainpicture;
	}
	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public String getClassinfo() {
		return classinfo;
	}
	public void setClassinfo(String classinfo) {
		this.classinfo = classinfo;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Tproperty getTproperty() {
		return tproperty;
	}
	public void setTproperty(Tproperty tproperty) {
		this.tproperty = tproperty;
	}
	public Tstudent getTstudent() {
		return tstudent;
	}
	public void setTstudent(Tstudent tstudent) {
		this.tstudent = tstudent;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
