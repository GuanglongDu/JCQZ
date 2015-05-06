package com.qcqz.util;

import java.util.Comparator;

import com.qcqz.domain.Tauth;

public class AuthComparator implements Comparator<Tauth> {

	@Override
	public int compare(Tauth o1, Tauth o2) {
		int i1 = o1.getCseq() != null ? o1.getCseq().intValue() : -1;
		int i2 = o2.getCseq() != null ? o2.getCseq().intValue() : -1;
		return i1 - i2;
	}

}
