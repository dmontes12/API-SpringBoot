package com.montec.apirest.blog.two.app.dto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.montec.apirest.blog.two.app.entities.Factura;
import com.montec.apirest.blog.two.app.entities.Producto;
@JsonSerialize
public class LineaFacturaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long cantidad;
	
	private Factura factura;
	private Producto producto;
	private Date createAt;
	
	public LineaFacturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
