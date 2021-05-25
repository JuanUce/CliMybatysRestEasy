package com.programacion.db;

public class Autor {

	private Long id;
	private Long edad;
	private String genero;
	private String nombre;
	
	public Autor() {
    }
	public Autor(Long id, Long edad, String genero, String nombre) {
        this.id = id;
        this.edad=edad;
        this.genero=genero;
        this.nombre=nombre;
    }
	
	public Autor(Long edad, String genero, String nombre) {
        this.edad=edad;
        this.genero=genero;
        this.nombre=nombre;
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
