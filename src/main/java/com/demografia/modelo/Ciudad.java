package com.demografia.modelo;
public class Ciudad{
	private int id;
	private String nombre;
	//Error: Faltaba el paisId, con su getter y setter y tambien mostrarlo en mostrarDatos
	private int paisId;
	
	public Ciudad(String nombre, int id, int paisId) {
		//Error: El ID del constructor se tomaba con un getter y no con el parametro
		this.id = id;
		this.nombre = nombre;
		this.paisId = paisId;
	}
	
	public void setId() {
		this.id = this.id+1;
	}
	
	public int getId() {
		setId();
		return this.id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setPaisId() {
		this.id = this.paisId+1;
	}
	
	public int getPaisId() {
		setPaisId();
		return this.paisId;
	}
	
	public void mostrarDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Ciudad: " + this.nombre);
		System.out.println("Pais ID: " + this.paisId);
	}
}
