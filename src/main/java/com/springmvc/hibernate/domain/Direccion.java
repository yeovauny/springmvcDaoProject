package com.springmvc.hibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCION")
public class Direccion {

	
	@Id
	@Column(name="PK_DIRECCION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
	@SequenceGenerator(name = "SEQ" , sequenceName = "seq_direccion")
	private int pk_direccion;
	

	@Column(name ="COMUNA")
	private String comuna;

	@Column(name ="DIRECCION")
	private String direccion;
	
	@Column(name ="NUMERO")
	private int numero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="USUARIO_ID",nullable=false)
	private Usuario usuario_id;
	
	
	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		
		
		this.usuario_id = usuario_id;
	}

	public int getId() {
		return pk_direccion;
	}

	public void setId(int id) {
		this.pk_direccion = pk_direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	
}
