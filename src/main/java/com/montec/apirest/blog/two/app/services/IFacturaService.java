package com.montec.apirest.blog.two.app.services;

import com.montec.apirest.blog.two.app.dto.FacturaDTO;
import com.montec.apirest.blog.two.app.entities.Factura;

public interface IFacturaService{
	public Factura encontrarFacturaPorId(Long idCliente, Long idFactura);
	public FacturaDTO crearFactura(FacturaDTO facturaDTO, Long id);
}
