package com.qcqz.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tgroupletters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cid;
	private Tletter tletter;
	private String cdesc;
	private BigDecimal cseq;
	private Tproperty tproperty;
	public Tgroupletters(){}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public Tletter getTletter() {
		return tletter;
	}
	public void setTletter(Tletter tletter) {
		this.tletter = tletter;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public BigDecimal getCseq() {
		return cseq;
	}
	public void setCseq(BigDecimal cseq) {
		this.cseq = cseq;
	}

	public Tproperty getTproperty() {
		return tproperty;
	}

	public void setTproperty(Tproperty tproperty) {
		this.tproperty = tproperty;
	}


	
}
