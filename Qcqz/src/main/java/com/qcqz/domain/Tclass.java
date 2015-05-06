package com.qcqz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tclass implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cid;
	private Tclass tclass;
	private String cdesc;
	private String ciconcls;
	private String cname;
	private BigDecimal cseq;
	private Set tclasses = new HashSet(0);
	private Set tstudent = new HashSet(0);
	
	public Tclass(){}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Tclass getTclass() {
		return tclass;
	}
	public void setTclass(Tclass tclass) {
		this.tclass = tclass;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getCiconcls() {
		return ciconcls;
	}
	public void setCiconcls(String ciconcls) {
		this.ciconcls = ciconcls;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public BigDecimal getCseq() {
		return cseq;
	}
	public void setCseq(BigDecimal cseq) {
		this.cseq = cseq;
	}
	public Set getTclasses() {
		return tclasses;
	}
	public void setTclasses(Set tclasses) {
		this.tclasses = tclasses;
	}
	public Set getTstudent() {
		return tstudent;
	}
	public void setTstudent(Set tstudent) {
		this.tstudent = tstudent;
	}
	
	
}
