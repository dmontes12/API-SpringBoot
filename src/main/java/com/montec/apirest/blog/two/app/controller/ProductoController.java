package com.montec.apirest.blog.two.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montec.apirest.blog.two.app.dto.ProductoDTO;
import com.montec.apirest.blog.two.app.entities.Producto;
import com.montec.apirest.blog.two.app.services.IProductoService;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping
	public List<Producto> obtenerTodosProductos(){
		
		return productoService.encontrarTodos();
	}
	
	@GetMapping("/{idProducto}")
	public ResponseEntity<Producto> obtenerPorId(@PathVariable Long idProducto){
		
		return new ResponseEntity<Producto>(productoService.encontrarPorId(idProducto),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO){
		
		
		return new ResponseEntity<ProductoDTO>(productoService.crearProducto(productoDTO),HttpStatus.CREATED);
	}
	
}

