package com.montec.apirest.blog.two.app.services;

import com.montec.apirest.blog.two.app.dto.FacturaDTO;

public interface IFacturaService{
	public FacturaDTO encontrarFacturaPorId(Long id);
	public FacturaDTO crearFactura(FacturaDTO facturaDTO, Long id);
}
