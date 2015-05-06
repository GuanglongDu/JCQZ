package com.qcqz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Tproperty implements Serializable {
	
	private String cid;
	private Tproperty tproperty;
	private String cdesc;
	private String ciconcls;
	private String cname;
	private BigDecimal cseq;
	private Set tproperties = new HashSet(0);
	private Set twords = new HashSet(0);
	private Set tgroupletters = new HashSet(0);
	
	public Tproperty(String cid, Tproperty tproperty, String cdesc, String ciconcls,
			String cname, BigDecimal cseq, Set tproperties) {
		this.cid = cid;
		this.tproperty = tproperty;
		this.cdesc = cdesc;
		this.ciconcls = ciconcls;
		this.cname = cname;
		this.cseq = cseq;
		this.tproperties = tproperties;
	}
	
	public Tproperty() {
	}

	/** minimal constructor */
	public Tproperty(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Tproperty getTproperty() {
		return tproperty;
	}

	public void setTproperty(Tproperty tproperty) {
		this.tproperty = tproperty;
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

	public Set getTproperties() {
		return tproperties;
	}

	public void setTproperties(Set tproperties) {
		this.tproperties = tproperties;
	}

	public Set getTwords() {
		return twords;
	}

	public void setTwords(Set twords) {
		this.twords = twords;
	}

	public Set getTgroupletters() {
		return tgroupletters;
	}

	public void setTgroupletters(Set tgroupletters) {
		this.tgroupletters = tgroupletters;
	}
	
}
