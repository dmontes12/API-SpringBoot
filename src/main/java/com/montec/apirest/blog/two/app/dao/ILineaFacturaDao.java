package com.montec.apirest.blog.two.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montec.apirest.blog.two.app.entities.LineaFactura;

public interface ILineaFacturaDao extends JpaRepository<LineaFactura, Long>{

}
