package com.montec.apirest.blog.two.app.dto;

import java.io.Serializable;

public class ProductoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private Double precio;
	
	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
