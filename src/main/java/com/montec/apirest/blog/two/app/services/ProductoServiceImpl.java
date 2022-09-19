package com.montec.apirest.blog.two.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montec.apirest.blog.two.app.dao.IProductoDao;
import com.montec.apirest.blog.two.app.dto.ProductoDTO;
import com.montec.apirest.blog.two.app.entities.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Producto> encontrarTodos() {
		// TODO Auto-generated method stub
		return productoDao.findAll() ;
	}

	@Override
	public Producto encontrarPorId(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public ProductoDTO crearProducto(ProductoDTO productoDTO) {
		Producto producto = convertToEntity(productoDTO);
		producto = productoDao.save(producto);
		
		
		
		return convertToDto(producto);
	}

	public ProductoDTO convertToDto(Producto producto) {
		ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
	    return productoDTO;
	}
	
	public Producto convertToEntity(ProductoDTO productoDTO) {
		Producto producto = modelMapper.map(productoDTO, Producto.class);
	    return producto;
	}

	
}
