package com.qcqz.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */

public class Tuser implements java.io.Serializable {

	// Fields

	private String cid;
	private Tdept tdept;
	private Date ccreatedatetime;
	private String cemail;
	private Date cmodifydatetime;
	private String cname;
	private String cpwd;
	private String crealname;
	private String csn;
	private String cstatus;
	private Set tusertroles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String cid, String cname, String cpwd, String crealname) {
		this.cid = cid;
		this.cname = cname;
		this.cpwd = cpwd;
		this.crealname = crealname;
	}

	/** full constructor */
	public Tuser(String cid, Tdept tdept, Timestamp ccreatedatetime,
			String cemail, Timestamp cmodifydatetime, String cname,
			String cpwd, String crealname, String csn, String cstatus,
			Set tusertroles) {
		this.cid = cid;
		this.tdept = tdept;
		this.ccreatedatetime = ccreatedatetime;
		this.cemail = cemail;
		this.cmodifydatetime = cmodifydatetime;
		this.cname = cname;
		this.cpwd = cpwd;
		this.crealname = crealname;
		this.csn = csn;
		this.cstatus = cstatus;
		this.tusertroles = tusertroles;
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

	public Date getCcreatedatetime() {
		return this.ccreatedatetime;
	}

	public void setCcreatedatetime(Date ccreatedatetime) {
		this.ccreatedatetime = ccreatedatetime;
	}

	public String getCemail() {
		return this.cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public Date getCmodifydatetime() {
		return this.cmodifydatetime;
	}

	public void setCmodifydatetime(Date cmodifydatetime) {
		this.cmodifydatetime = cmodifydatetime;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCpwd() {
		return this.cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCrealname() {
		return this.crealname;
	}

	public void setCrealname(String crealname) {
		this.crealname = crealname;
	}

	public String getCsn() {
		return this.csn;
	}

	public void setCsn(String csn) {
		this.csn = csn;
	}

	public String getCstatus() {
		return this.cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public Set getTusertroles() {
		return this.tusertroles;
	}

	public void setTusertroles(Set tusertroles) {
		this.tusertroles = tusertroles;
	}

}