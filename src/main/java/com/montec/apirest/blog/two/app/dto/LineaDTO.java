package com.montec.apirest.blog.two.app.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize
public class LineaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long cantidad;
	private Long producto;
	
	public LineaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getProducto() {
		return producto;
	}
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	
	
	
}
