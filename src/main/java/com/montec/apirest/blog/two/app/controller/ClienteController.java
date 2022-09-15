package com.montec.apirest.blog.two.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montec.apirest.blog.two.app.dto.ClienteDTO;
import com.montec.apirest.blog.two.app.services.IClienteService;
@RestController
@RequestMapping("/api/clientes")
	public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/crear")
	public ResponseEntity<ClienteDTO> createClient(@RequestBody ClienteDTO clienteDTO){
		
		
		
		return new ResponseEntity<>(clienteService.createClient(clienteDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<ClienteDTO> findAllClientes(){
		
		return clienteService.findAllClientes();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarPorId(@PathVariable Long id){
		clienteService.eliminarClientePorId(id);
		return new ResponseEntity<String>("Cliente eliminado con exito",HttpStatus.OK);
	}
	
	             
} 