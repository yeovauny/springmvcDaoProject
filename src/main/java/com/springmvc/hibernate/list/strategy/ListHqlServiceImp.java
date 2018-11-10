package com.springmvc.hibernate.list.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.hibernate.domain.Usuario;


@Service
public class ListHqlServiceImp implements ListHqlService {
	@Autowired
	UsuarioListHqlDao usuarioListHqlDao;
	
	
	@Transactional
	@Override
	public List<Usuario> finddatabyId(String id) {
		
		return usuarioListHqlDao.findByHqlQuery("from Usuario where id="+id+" ");
	}

}
