package com.qcqz.util;

import java.util.Comparator;

import com.qcqz.domain.Tclass;

public class ClassComparator implements Comparator<Tclass> {

	@Override
	public int compare(Tclass o1, Tclass o2) {
		int i1 = o1.getCseq() != null ? o1.getCseq().intValue() : -1;
		int i2 = o2.getCseq() != null ? o2.getCseq().intValue() : -1;
		return i1 - i2;
	}

}
