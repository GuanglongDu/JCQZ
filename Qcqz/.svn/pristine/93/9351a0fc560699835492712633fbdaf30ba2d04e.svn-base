package com.qcqz.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *BaseGenericDataAccessor的基础实现类，通过调用Hibernate的原生API提供基础的CRUD功能 
 */
public abstract class BaseGenericDataAccessor<E extends Serializable,EID extends Serializable> implements GenericDataAccessor<E,EID> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<E> entityClass;
	
	/**
	 * 通过反射获取子类确定的泛型类,构造方法完成后立刻执行
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	@PostConstruct
	private void initlization(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<E>) params[0];
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	@SuppressWarnings("unchecked")
	public E load(EID id) {
		return (E)getSession().load(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> loadAll(){
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria.list();
	}

	public void saveOrUpdate(E o) {
		this.getSession().saveOrUpdate(o);
	}
	
	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	@SuppressWarnings("unchecked")
	public E get(EID id) {
		return (E) getSession().get(entityClass, id);
	}

	public E get(String hql, Object[] param) {
		List<E> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}
	
	public E get(Class<E> c, Serializable id) {
		return (E) this.getSession().get(c, id);
	}
	/**
	 * 保存PO
	 * 
	 * @param entity
	 */
	@SuppressWarnings("unchecked")
	public EID save(E entity) {
		 return (EID)getSession().save(entity);
	}

	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	public void delete(E entity) {
		getSession().delete(entity);
	}

	
	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	public void update(E entity) {
		getSession().saveOrUpdate(entity);
	}

	/**
	 * 执行HQL查询
	 * 
	 * @param sql
	 * @return 查询结果
	 */
	public List<E> find(String hql) {
		return createQuery(hql).list();
	}

	
    
	public List<E> find(String hql, Object[] param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	
	public List<E> find(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}
	
	public List<E> find(String hql, List<Object> param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	/**
	 * 对延迟加载的实体PO执行初始化
	 * @param entity
	 */
	public void initialize(Object entity) {
		Hibernate.initialize(entity);
	}
	
	public Query createQuery(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query;
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public E get(String hql, List<Object> param) {
		List<E> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}
	
	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}
	
	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}
	
	public Integer executeHql(String hql) {
		return this.getSession().createQuery(hql).executeUpdate();
	}
	
	public Long count(String hql) {
		return (Long) this.getSession().createQuery(hql).uniqueResult();
	}
	
	public Long count(String hql, Object[] param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}
	
	public Long count(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}
	
	public List<E> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
}
