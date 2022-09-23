package com.montec.apirest.blog.two.app.dto;

public class ErrorDTO {
	private String message;
	
	public ErrorDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public ErrorDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
