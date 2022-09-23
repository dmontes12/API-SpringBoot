package com.montec.apirest.blog.two.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.montec.apirest.blog.two.app.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
	
}
