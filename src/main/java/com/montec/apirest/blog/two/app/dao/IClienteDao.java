package com.montec.apirest.blog.two.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montec.apirest.blog.two.app.entities.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{
	
}
