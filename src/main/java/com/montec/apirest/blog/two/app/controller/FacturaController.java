 package com.montec.apirest.blog.two.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montec.apirest.blog.two.app.dto.FacturaDTO;
import com.montec.apirest.blog.two.app.entities.Factura;
import com.montec.apirest.blog.two.app.services.IFacturaService;

@RestController
@RequestMapping("/api/clientes")
public class FacturaController {
	@Autowired
	private IFacturaService facturaService;
	
	
	@PostMapping("/{idCliente}/facturas")
	public ResponseEntity<FacturaDTO> crearFactura(@PathVariable Long idCliente,@RequestBody FacturaDTO factura){
		
		
		return new ResponseEntity<FacturaDTO>(facturaService.crearFactura(factura, idCliente),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{idCliente}/facturas/{idFactura}")
	public Factura showFacturaId(@PathVariable Long idCliente,@PathVariable Long idFactura){
		
		return facturaService.encontrarFacturaPorId(idCliente, idFactura);
	}
}
