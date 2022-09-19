package com.montec.apirest.blog.two.app.services;

import java.util.List;

import com.montec.apirest.blog.two.app.dto.ClienteDTO;

public interface IClienteService {

	public ClienteDTO findById(Long id);
	public ClienteDTO createClient(ClienteDTO clienteDTO);
	public List<ClienteDTO> findAllClientes();
	public void eliminarCliente(ClienteDTO clienteDTO);
	public void eliminarClientePorId(Long id);
	
}
