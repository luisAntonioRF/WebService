package com.luis.app.soap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "services",schema = "developer")
public class Collaborator implements Serializable{

	private static final long serialVersionUID = 7265158378298172063L;
	
	@Id
	@Column(name = "collab_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
	@SequenceGenerator(name = "sequence",sequenceName = "services_seq",allocationSize = 1)
	private Long id;
	
	@Column(name = "collab_name")
	private String name;
	
	@Column(name = "collab_alias")
	private String alias;
	
	@Column(name = "collab_password")
	private String pass;
	
	@Column(name = "collab_dni")
	private String dni;
	
	@Column(name = "collab_email")
	private String email;
	
	@Lob
	@Column(name = "collab_image")
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
