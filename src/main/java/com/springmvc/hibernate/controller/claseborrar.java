package com.springmvc.hibernate.controller;

public class claseborrar {

	public claseborrar() {}
	
	
	private String nombre;
	
	private int cedula;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCedula() {
		return cedula;
	}


	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


	public void metodo() {
		
		System.out.println("el nombre es"+this.nombre);
		System.out.println("la edad es "+(this.cedula+100));
		
	}
}
