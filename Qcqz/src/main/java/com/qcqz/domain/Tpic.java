package com.qcqz.domain;

import java.io.Serializable;

public class Tpic implements Serializable {

	private String cid;
	private String cdesc;
	private String cname;
	private String pno;
	private String cpath;
	private Twords twords;
	private Tletter tletter;
	public Tpic(String cid,  String cdesc,
			String cname, String pno, String cpath,Twords twords,Tletter tletter) {
		this.cid = cid;
		this.cdesc = cdesc;
		this.cpath = cpath;
		this.cname = cname;
		this.pno = pno;
		this.twords = twords;
		this.tletter = tletter;
	}
	public Tpic(){}
	
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
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getCpath() {
		return cpath;
	}
	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	public Twords getTwords() {
		return twords;
	}
	public void setTwords(Twords twords) {
		this.twords = twords;
	}
	public Tletter getTletter() {
		return tletter;
	}
	public void setTletter(Tletter tletter) {
		this.tletter = tletter;
	}

	
}
