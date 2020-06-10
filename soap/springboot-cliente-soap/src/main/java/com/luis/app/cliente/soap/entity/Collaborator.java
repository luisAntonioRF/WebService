package com.luis.app.cliente.soap.entity;

import java.io.Serializable;


public class Collaborator implements Serializable{

	private static final long serialVersionUID = 7265158378298172063L;
	
	private Long id;
	
	private String name;
	
	private String alias;
	
	private String pass;
	
	private String dni;
	
	private String email;
	
	private byte[] img;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
	

}
