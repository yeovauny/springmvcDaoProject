package com.springmvc.hibernate.list.strategy;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.hibernate.domain.Usuario;
import com.springmvc.hibernate.generic.dao.BasicHibernateDao;
import com.springmvc.hibernate.generic.dao.GenericDaoImp;

@Repository
public class UsuarioListHqlDaoImp extends GenericDaoImp<Usuario,Long> implements UsuarioListHqlDao{
	
	
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Usuario> findByHqlQuery(String hql){
		System.out.println("pasa por aqui");
		return super.findByHqlQuery(hql);
	}
	
}
