package com.qcqz.util;

import java.util.Comparator;

import com.qcqz.domain.Tproperty;

public class PropertiesComparator implements Comparator<Tproperty> {

	@Override
	public int compare(Tproperty o1, Tproperty o2) {
		int i1 = o1.getCseq() != null ? o1.getCseq().intValue() : -1;
		int i2 = o2.getCseq() != null ? o2.getCseq().intValue() : -1;
		return i1 - i2;
	}

}
