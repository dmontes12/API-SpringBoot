package com.montec.apirest.blog.two.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montec.apirest.blog.two.app.entities.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{

}
