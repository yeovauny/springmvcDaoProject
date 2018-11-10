package com.springmvc.hibernate.list.strategy;
import java.util.List;

import com.springmvc.hibernate.domain.Usuario;;
public interface ListHqlService {

	public List<Usuario> finddatabyId(String id);
	
}
