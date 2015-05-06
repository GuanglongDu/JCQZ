package com.qcqz.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.qcqz.domain.Tstudent;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.qcqz.domain.Tstudent
 * @author MyEclipse Persistence Tools
 */
@Repository("tstudentDAO")
public class TstudentDAO extends BaseGenericDataAccessor<Tstudent,Integer> {
	
}