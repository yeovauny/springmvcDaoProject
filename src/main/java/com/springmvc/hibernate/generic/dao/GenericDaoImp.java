package com.springmvc.hibernate.generic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

// HIbernateDaoSuport, abstract class of hibernate
@SuppressWarnings("serial")
public abstract class GenericDaoImp<T, ID extends Serializable>    implements GenericDao<T,ID>{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> persistentClass;
	
	
	@SuppressWarnings("unchecked")
	public GenericDaoImp() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
		
	}
	
	
	@Override
	public void insert(T entity) {
		this.getCurrentSession().save(entity);
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> makeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<T> findByHqlQuery(String hql){
		Query query = getCurrentSession().createQuery(hql);
		List<T> list = new ArrayList<T>();
		return list=query.list();
	}

}
