package com.sergio.colegio.dtos;

public class UsuariosDTO {
	
	private String username;
	private String password;
	private String rol;
	public UsuariosDTO() {
		super();
	}
	public UsuariosDTO(String username, String password, String rol) {
		super();
		this.username = username;
		this.password = password;
		this.rol = rol;
	}
	
	
	public UsuariosDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public UsuariosDTO(String rol) {
		super();
		this.rol = rol;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
