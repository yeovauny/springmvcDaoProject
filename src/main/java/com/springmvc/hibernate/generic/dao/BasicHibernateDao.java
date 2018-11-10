package com.springmvc.hibernate.generic.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


@SuppressWarnings("unchecked")
public abstract class BasicHibernateDao<T> extends HibernateDaoSupport implements GenericDao{

	private Class<T> domainObjectClass;
	
	public Class<T> getDomainObjectClass() {
		return domainObjectClass;
	}

	public void setDomainObjectClass(Class<T> domainObjectClass) {
		this.domainObjectClass = domainObjectClass;
	}

	public BasicHibernateDao(final Class<T> domainObjectClass) {
		this.domainObjectClass=domainObjectClass;
		
	}

	public BasicHibernateDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		
		domainObjectClass = (Class<T>) (genericSuperclass.getActualTypeArguments()[0]);
	}
	
	
	
	
	@Override
	public void insert(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List makeList() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List findByHqlQuery(final String hql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().executeFind(new HibernateCallback<T>() {				
				@Override
				public T doInHibernate(Session session) throws HibernateException,SQLException{
					return (T) session.createQuery(hql).list();
					
					
				}
				
		});
	}

	@Override
	public List findByCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
