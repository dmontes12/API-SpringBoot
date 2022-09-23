package com.montec.apirest.blog.two.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.montec.apirest.blog.two.app.dao.IFacturaDao;
import com.montec.apirest.blog.two.app.dao.ILineaFacturaDao;
import com.montec.apirest.blog.two.app.dao.IProductoDao;
import com.montec.apirest.blog.two.app.dto.LineaDTO;
import com.montec.apirest.blog.two.app.dto.LineaFacturaDTO;
import com.montec.apirest.blog.two.app.entities.Factura;
import com.montec.apirest.blog.two.app.entities.LineaFactura;
import com.montec.apirest.blog.two.app.entities.Producto;

@Service
public class LineaFacturaImpl implements ILineaFacturaService{
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private ILineaFacturaDao lineaFacturaDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LineaFacturaDTO agregarLineaFactura(LineaDTO lineaDTO, Long idFactura) {
		LineaFactura lineaFactura = new LineaFactura();
	
		Factura factura = facturaDao.findById(idFactura).orElse(null);
		Producto producto = productoDao.findById(lineaDTO.getProducto()).get();
		
		lineaFactura.setFactura(factura);
		lineaFactura.setProducto(producto);
		lineaFactura.setCantidad(lineaDTO.getCantidad());
		
		
		lineaFactura = lineaFacturaDao.save(lineaFactura);
		LineaFacturaDTO lineaFacturaDTO = convertToDto(lineaFactura);
		
		return lineaFacturaDTO;
	}

	@Override
	public LineaFacturaDTO encontrarLineaFacturaPorId(Long id) {
		LineaFactura lineaFactura = lineaFacturaDao.findById(id).orElse(null);
		
		
		return convertToDto(lineaFactura);
	}

	@Override
	public void eliminarFacturaPorId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	public LineaFacturaDTO convertToDto(LineaFactura lineaFactura) {
		LineaFacturaDTO lineaFacturaDTO = modelMapper.map(lineaFactura, LineaFacturaDTO.class);
	    return lineaFacturaDTO;
	}
	
	public LineaFactura convertToEntity(LineaFacturaDTO lineaFacturaDTO) {
		LineaFactura lineaFactura = modelMapper.map(lineaFacturaDTO, LineaFactura.class);
	    return lineaFactura;
	}

	@Override
	public List<LineaFactura> encontrarTodasDeCliente(Long idFactura) {
		Factura factura = facturaDao.findById(idFactura).orElse(null);
		
		return factura.getLineasfactura();
	}
	


}
