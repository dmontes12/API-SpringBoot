package com.montec.apirest.blog.two.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montec.apirest.blog.two.app.dao.IClienteDao;
import com.montec.apirest.blog.two.app.dto.ClienteDTO;
import com.montec.apirest.blog.two.app.entities.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ClienteDTO findById(Long id) {
		
		Cliente cliente = clienteDao.findById(id).orElse(null);
		ClienteDTO clienteDTO = convertToDto(cliente);
		return clienteDTO;
	}


	@Override
	public ClienteDTO createClient(ClienteDTO clienteDTO) {
		Cliente cliente = convertToEntity(clienteDTO);
		cliente = clienteDao.save(cliente);
		clienteDTO = convertToDto(cliente);
		
		return clienteDTO;
	}



	@Override
	public List<ClienteDTO> findAllClientes() {
		List<Cliente> clienteList = clienteDao.findAll();
		List<ClienteDTO> clientesDtoList = clienteList.stream().map(cliente -> convertToDto(cliente)).collect(Collectors.toList());
		
		return clientesDtoList;
	}
	
	
	
	private ClienteDTO convertToDto(Cliente cliente) {
		ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
	    return clienteDTO;
	}
	
	private Cliente convertToEntity(ClienteDTO clienteDTO) {
		Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
	    return cliente;
	}


	@Override
	public void eliminarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = convertToEntity(clienteDTO);
		
		clienteDao.delete(cliente);
		
	}


	@Override
	public void eliminarClientePorId(Long id) {
		// TODO Auto-generated method stub
			clienteDao.deleteById(id);

	}

}
