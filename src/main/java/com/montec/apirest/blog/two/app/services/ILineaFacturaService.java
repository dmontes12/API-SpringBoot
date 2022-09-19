package com.montec.apirest.blog.two.app.services;

import java.util.List;

import com.montec.apirest.blog.two.app.dto.LineaDTO;
import com.montec.apirest.blog.two.app.dto.LineaFacturaDTO;
import com.montec.apirest.blog.two.app.entities.LineaFactura;

public interface ILineaFacturaService {
	public LineaFacturaDTO agregarLineaFactura(LineaDTO lineaDTO, Long idFactura);
	public LineaFacturaDTO encontrarLineaFacturaPorId(Long id);
	public List<LineaFactura> encontrarTodasDeCliente(Long idFactura);
	public void eliminarFacturaPorId(Long id);
}
