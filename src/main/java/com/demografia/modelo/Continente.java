package com.demografia.modelo;
public class Continente{
	private int id;
	private String nombre;
	
	public void setId() {
		this.id = this.id+1;
	}
	
	public int getId() {
		setId();
		return this.id;
	}
	public Continente(String nombre, int id) {
		//Error: El ID del constructor se tomaba con un getter y no con el parametro
		this.id = id;
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void mostrarDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Continente: " + this.nombre);
	}
}
