package com.demografia.modelo;
public class Pais{
	private int id;
	private String nombre;
	private int poblacion;
	//Error: Faltaba el continenteId, con su getter y setter y tambien mostrarlo en mostrarDatos
	private int continenteId;
	
	public void setId() {
		this.id = this.id+1;
	}
	
	public int getId() {
		setId();
		return this.id;
	}
	
	public Pais(String nombre, int id, int poblacion, int continenteId) {
		//Error: El ID del constructor se tomaba con un getter y no con el parametro
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.continenteId = continenteId;

	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	
	public int getpoblacion() {
		return this.poblacion;
	}
	
	public void setContinenteId() {
		this.id = this.continenteId+1;
	}
	
	public int getContinenteId() {
		setContinenteId();
		return this.continenteId;
	}
	
	
	public void mostrarDatos() {
		//Error: Faltaba mostrar la poblacion y el id del continente
		System.out.println("ID: " + this.id);
		System.out.println("Pais: " + this.nombre);
		System.out.println("Poblacion: " + this.poblacion);
		System.out.println("ContinenteId: " + this.continenteId);
	}
}
