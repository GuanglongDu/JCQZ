package com.qcqz.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Tdept entity. @author MyEclipse Persistence Tools
 */

public class Tdept implements java.io.Serializable {

	// Fields

	private String cid;
	private Tdept tdept;
	private String cdesc;
	private String ciconcls;
	private String cname;
	private BigDecimal cseq;
	private Set tusers = new HashSet(0);
	private Set tdepts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tdept() {
	}

	/** minimal constructor */
	public Tdept(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	/** full constructor */
	public Tdept(String cid, Tdept tdept, String cdesc, String ciconcls,
			String cname, BigDecimal cseq, Set tusers, Set tdepts) {
		this.cid = cid;
		this.tdept = tdept;
		this.cdesc = cdesc;
		this.ciconcls = ciconcls;
		this.cname = cname;
		this.cseq = cseq;
		this.tusers = tusers;
		this.tdepts = tdepts;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Tdept getTdept() {
		return this.tdept;
	}

	public void setTdept(Tdept tdept) {
		this.tdept = tdept;
	}

	public String getCdesc() {
		return this.cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public String getCiconcls() {
		return this.ciconcls;
	}

	public void setCiconcls(String ciconcls) {
		this.ciconcls = ciconcls;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public BigDecimal getCseq() {
		return this.cseq;
	}

	public void setCseq(BigDecimal cseq) {
		this.cseq = cseq;
	}

	public Set getTusers() {
		return this.tusers;
	}

	public void setTusers(Set tusers) {
		this.tusers = tusers;
	}

	public Set getTdepts() {
		return this.tdepts;
	}

	public void setTdepts(Set tdepts) {
		this.tdepts = tdepts;
	}

}