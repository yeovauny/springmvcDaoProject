package com.springmvc.hibernate.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	/**
	 * 
	 */
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
	@SequenceGenerator(name = "SEQ" , sequenceName = "seq_usuario")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@OneToMany(mappedBy ="usuario_id",cascade= {CascadeType.ALL},fetch = FetchType.EAGER)//fetch = FetchType.EAGER, cascade={CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE} )
	 @Column(name="USUARIO_ID", nullable = false)
	 private Set<Direccion> direccion  ; 
	
	@Column(name ="NOMBRE")
	private String nombre;

	public Set<Direccion> getDireccion() {
		return direccion;
	}

	
	public void addDireccion (Direccion direccionObject) {
		//funcion critica para el llenado del objecto
		if(direccion==null) {
			direccion= new HashSet<Direccion>();
			direccionObject.setUsuario_id(this);
			direccion.add(direccionObject);
			
		}else {
			direccionObject.setUsuario_id(this);
			direccion.add(direccionObject);
			
		}
		
		
	}
	

	public void setDireccion(Set<Direccion> direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
