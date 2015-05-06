package com.qcqz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tstudentclass implements Serializable {

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
	private Set tpics = new HashSet(0);

	public Tstudentclass(){}
	
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

	public Set getTpics() {
		return tpics;
	}

	public void setTpics(Set tpics) {
		this.tpics = tpics;
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

	
}
