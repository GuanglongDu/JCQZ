package com.qcqz.dao;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;


@ContextConfiguration("classpath:qcqz-dao.xml")
@TransactionConfiguration(defaultRollback=false)
public class BaseQcqzDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
}
