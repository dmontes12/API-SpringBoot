package com.montec.apirest.blog.two.app.dto;

import java.io.Serializable;
import java.util.Date;

import com.montec.apirest.blog.two.app.entities.Cliente;

public class FacturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private String observacion;
	private Date createAt;
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
