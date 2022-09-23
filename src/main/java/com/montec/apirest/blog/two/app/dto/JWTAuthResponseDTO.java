package com.montec.apirest.blog.two.app.dto;

public class JWTAuthResponseDTO {
	private String tokenDeAcceso;
	private String tipoDeToken = "Bearer";

	public JWTAuthResponseDTO(String tokenDeAcceso, String tipoDeToken) {
		this.tokenDeAcceso = tokenDeAcceso;
		this.tipoDeToken = tipoDeToken;
	}
	
	public JWTAuthResponseDTO(String tokenDeAcceso) {
		this.tokenDeAcceso = tokenDeAcceso;
	}

	public String getTokenDeAcceso() {
		return tokenDeAcceso;
	}

	public void setTokenDeAcceso(String tokenDeAcceso) {
		this.tokenDeAcceso = tokenDeAcceso;
	}

	public String getTipoDeToken() {
		return tipoDeToken;
	}

	public void setTipoDeToken(String tipoDeToken) {
		this.tipoDeToken = tipoDeToken;
	}

}
