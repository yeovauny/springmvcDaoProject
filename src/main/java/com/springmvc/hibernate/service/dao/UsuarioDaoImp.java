package com.springmvc.hibernate.service.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.springmvc.hibernate.domain.Usuario;
import com.springmvc.hibernate.generic.dao.GenericDaoImp;


@Repository
public class UsuarioDaoImp extends GenericDaoImp<Usuario,Long> implements UsuarioDao {

	private SessionFactory sessionFactory;
	
	public UsuarioDaoImp() {}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void delete(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> makeList() {
		
		return null;
	}

	@Override
	public List<Usuario> findByCriteria(Criterion... criterions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Usuario usuario) {
		super.insert(usuario);	
	}
	
	@Override
	public List<Usuario> findByHqlQuery(String hql){
		
		return super.findByHqlQuery(hql);
	}

}
