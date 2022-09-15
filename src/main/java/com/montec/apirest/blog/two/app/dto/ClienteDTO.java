package com.montec.apirest.blog.two.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.montec.apirest.blog.two.app.entities.Factura;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String apellido;
	private List<Factura> facturas;
	private String email;
	private Date createAt;
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
		facturas = new ArrayList<>();
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	 
	
	
}
