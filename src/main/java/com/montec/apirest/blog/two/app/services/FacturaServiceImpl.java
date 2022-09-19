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
	public Factura encontrarFacturaPorId(Long idCliente,Long idFactura) {
		
		Factura factura = facturaDao.findById(idFactura).orElse(null);
		
		if(idCliente == factura.getCliente().getId()) {
			return factura;
		}
		
		return null;
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
