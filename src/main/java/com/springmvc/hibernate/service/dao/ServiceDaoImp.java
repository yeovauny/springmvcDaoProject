package com.springmvc.hibernate.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.hibernate.domain.Usuario;


@Service
public class ServiceDaoImp implements ServiceDao{

	public ServiceDaoImp() {}
	
	@Autowired
	UsuarioDao usuarioDao;
	@Transactional
	@Override
	public void saveInformation(Usuario usuario) {
		usuarioDao.insert(usuario);
		System.out.println("esta guardando informacion");
	}

}
