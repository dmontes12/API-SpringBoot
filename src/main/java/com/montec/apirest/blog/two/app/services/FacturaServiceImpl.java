package com.montec.apirest.blog.two.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montec.apirest.blog.two.app.dao.IClienteDao;
import com.montec.apirest.blog.two.app.dao.IFacturaDao;
import com.montec.apirest.blog.two.app.dto.FacturaDTO;
import com.montec.apirest.blog.two.app.entities.Cliente;
import com.montec.apirest.blog.two.app.entities.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{
	@Autowired
	private IFacturaDao facturaDao;
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FacturaDTO encontrarFacturaPorId(Long id) {
		
		Factura factura = facturaDao.findById(id).orElse(null);
		FacturaDTO facturaDTO = convertToDto(factura);
		
		return facturaDTO;
	}

	@Override
	public FacturaDTO crearFactura(FacturaDTO facturaDTO, Long id) {
		Cliente cliente = clienteDao.findById(id).orElse(null);
		Factura factura = convertToEntity(facturaDTO);
		factura.setCliente(cliente);
		//cliente = clienteDao.save(cliente);
		factura = facturaDao.save(factura);
		
		return convertToDto(factura);
	}
	
	public FacturaDTO convertToDto(Factura factura) {
		FacturaDTO facturaDTO = modelMapper.map(factura, FacturaDTO.class);
	    return facturaDTO;
	}
	
	public Factura convertToEntity(FacturaDTO facturaDTO) {
		Factura factura = modelMapper.map(facturaDTO, Factura.class);
	    return factura;
	}

	
}
