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

import com.montec.apirest.blog.two.app.dto.LineaDTO;
import com.montec.apirest.blog.two.app.dto.LineaFacturaDTO;
import com.montec.apirest.blog.two.app.entities.LineaFactura;
import com.montec.apirest.blog.two.app.services.ILineaFacturaService;

@RestController
@RequestMapping("api/clientes/")
public class LineaFacturaController {
	
	@Autowired
	private ILineaFacturaService lineaFacturaService;
	
	//FALTA VALIDAR CON CLIENTE
	@PostMapping("{idCliente}/facturas/{idFactura}")
	public ResponseEntity<LineaFacturaDTO> agregarLinea(
			@PathVariable Long idCliente,
			@PathVariable Long idFactura,
			@RequestBody LineaDTO lineaDto){
				
		return new ResponseEntity<LineaFacturaDTO>(
				lineaFacturaService.agregarLineaFactura(lineaDto, idFactura)
				,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("facturas/{idFactura}/lineas")
	public List<LineaFactura> obtenerLineaFactura(@PathVariable Long idFactura){
		return lineaFacturaService.encontrarTodasDeCliente(idFactura);
	}
}
