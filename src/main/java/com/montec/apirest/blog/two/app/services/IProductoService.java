package com.montec.apirest.blog.two.app.services;

import java.util.List;

import com.montec.apirest.blog.two.app.dto.ProductoDTO;
import com.montec.apirest.blog.two.app.entities.Producto;

public interface IProductoService {
	public List<Producto> encontrarTodos();
	public Producto encontrarPorId(Long id);
	public ProductoDTO crearProducto(ProductoDTO productoDTO);

}
