package com.springmvc.hibernate.persistence;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.hibernate.domain.Direccion;
import com.springmvc.hibernate.domain.Usuario;
import com.springmvc.hibernate.service.dao.ServiceDao;

public class TransactionPersistence {

	@Autowired
	private ServiceDao service;
	
	public TransactionPersistence() {}
	
	public void requestPersistence(JSONObject mapRequest) 
	
	{
		Usuario usuario= new Usuario();
		usuario.setNombre(mapRequest.getJSONObject("entranda").getJSONObject("primaryConsumer").getJSONObject("secundaryConsumer").getString("Apellido"));
		
		JSONArray direccionArray=mapRequest.getJSONObject("entranda").getJSONObject("primaryConsumer").getJSONObject("secundaryConsumer").getJSONArray("Direccion");
		if(direccionArray.length()>0) 
		{
			
			Set<Direccion> listaDireccion = new HashSet<Direccion>();
			for (int i=0;i<direccionArray.length();i++)
			{
				JSONObject jsonDireccion = direccionArray.getJSONObject(i);
				Direccion direccion = new Direccion();
				direccion.setComuna(jsonDireccion.getString("Comuna"));
				direccion.setDireccion(jsonDireccion.getString("Direccion"));
				direccion.setNumero(Integer.valueOf(jsonDireccion.getString("numero")));
				listaDireccion.add(direccion);
				//important part, for update the variable direccion 
				usuario.addDireccion(direccion);
			}
			//setting the list of direction on Usuario pojo
			usuario.setDireccion(listaDireccion);
		}
		
		
		
		
		service.saveInformation(usuario);
		
		
	}
	
	
}
