package com.springmvc.hibernate.generic.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;
public interface GenericDao<T, ID> extends Serializable {

	void insert(T t);
	void delete(T t);
	T searchById(Long id);
	T update(T t);
	List<T> makeList();
	List<T> findByCriteria(Criterion... criterions);
	
	List<T> findByHqlQuery(String hql);
}
