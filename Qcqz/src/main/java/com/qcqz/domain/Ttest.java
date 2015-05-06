package com.qcqz.domain;

import java.io.Serializable;
import java.util.Date;

public class Ttest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cid;
	private Date cdate;
	private Tstudent tStudent;
	private String cdesc;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Tstudent gettStudent() {
		return tStudent;
	}
	public void settStudent(Tstudent tStudent) {
		this.tStudent = tStudent;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
}
