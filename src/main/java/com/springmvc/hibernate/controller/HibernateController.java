package com.springmvc.hibernate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.hibernate.domain.Direccion;
import com.springmvc.hibernate.domain.Usuario;
import com.springmvc.hibernate.list.strategy.StrategyListHql;
import com.springmvc.hibernate.persistence.TransactionPersistence;
import com.springmvc.hibernate.save.HibernateSave;
import com.springmvc.hibernate.service.dao.ServiceDao;
import com.springmvc.hibernate.service.dao.ServiceDaoImp;

@Controller
@RequestMapping("/hibernatecontroller")
public class HibernateController {

	@Autowired
	private HibernateSave hibernateSave;
	
	@Autowired
	 private TransactionPersistence transactionPersistence;
	@Autowired
	private StrategyListHql strategyListHql;
	
	
	@Autowired
	private claseborrar claseBorrar;
	
	@RequestMapping(value="/test/", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> submit(@RequestBody(required =true) final String data){
		Map<String, Object> externa= new HashMap<String,Object>();
		
		
		JSONObject jsonRequest = convertStringToJsonObject(data);
		transactionPersistence.requestPersistence(jsonRequest);
		externa.put("hola", "mundo");
		externa.put("test", "test1");
		
		//Usuario usu= new Usuario();
		
		//usu.setNombre(jsonRequest.getJSONObject("entranda").getJSONObject("primaryConsumer").getJSONObject("secundaryConsumer").getString("Apellido"));
		
		/*Set<Direccion> listaDireccion = new HashSet<Direccion>();
		Direccion direccion = new Direccion();
		direccion.setComuna("Santiago Centro");
		direccion.setDireccion("Garcia Reyes");
		direccion.setNumero(30);
		//punto clave para el llenado del @Onetomany
		usu.addDireccion(direccion);
		listaDireccion.add(direccion);
		
		
		usu.setDireccion(listaDireccion);
		
		//service.saveInformation(usu);
		
		
		claseBorrar.metodo();
		
		hibernateSave.save();
		
		int numero =10/0;
		
		System.out.println("valores de entrada son "+data);*/

		return new ResponseEntity<Object> (jsonRequest ,HttpStatus.OK);
	}
	
	public JSONObject convertStringToJsonObject(String data) {
		
		JSONObject json= new JSONObject(data);
		 
		return json;
	}
	
	
	@RequestMapping(value="/search/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> search(){
		Map<String,Object> response= strategyListHql.mapa();
		
		return new ResponseEntity<Object> (response ,HttpStatus.OK);
	}
	
	
	
	
}
