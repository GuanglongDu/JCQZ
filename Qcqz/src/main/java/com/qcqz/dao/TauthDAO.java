package com.qcqz.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.qcqz.domain.Tauth;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authority entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.qcqz.domain.Authority
 * @author MyEclipse Persistence Tools
 */
@Repository("tauthDAO")
public class TauthDAO extends BaseGenericDataAccessor<Tauth,Integer> {
	private static final Logger log = LoggerFactory
			.getLogger(TauthDAO.class);
	
}