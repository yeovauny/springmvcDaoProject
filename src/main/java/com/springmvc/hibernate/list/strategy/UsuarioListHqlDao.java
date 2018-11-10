package com.springmvc.hibernate.list.strategy;

import java.util.List;

import com.springmvc.hibernate.domain.Usuario;

public interface UsuarioListHqlDao {
	public List<Usuario> findByHqlQuery(String hqlQuery);
}
