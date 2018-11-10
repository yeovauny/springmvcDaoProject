package com.springmvc.hibernate.list.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvc.hibernate.domain.Direccion;
import com.springmvc.hibernate.domain.Usuario;

@Component
public class StrategyListHql {
	@Autowired
	ListHqlService listHqlService; 
	public Map<String,Object> mapa() {
		List<Usuario> usuarioList = listHqlService.finddatabyId("8900");
		
		
		Map<String, Object> mapaUsuario = new HashMap<String,Object>();
		
		if(usuarioList!=null) {
			
			
			mapaUsuario.put("ID", usuarioList.get(0).getId());
			mapaUsuario.put("Nombre", usuarioList.get(0).getNombre());
			mapaUsuario.put("Direcciones",putMapDireccion(usuarioList.get(0).getDireccion()));
			//mapaUsuario.putAll();
			
			
			System.out.println("mapa "+mapaUsuario);
		}
		return mapaUsuario;
	}
	
	private List<Object> putMapDireccion (Set<Direccion> listaDireccion) {
		
		List<Object> listaMapa = new ArrayList<Object>();
		Map<String, Object> mapaDicreccion = new HashMap<String,Object>();
		for(Direccion direccion:listaDireccion) {
			
			mapaDicreccion.put("Comuna", direccion.getComuna());
			mapaDicreccion.put("Direccion", direccion.getDireccion());
			mapaDicreccion.put("Numero", direccion.getNumero());
			listaMapa.add(mapaDicreccion);
			
		}
		
		return listaMapa;
		
	}
	
	
}
