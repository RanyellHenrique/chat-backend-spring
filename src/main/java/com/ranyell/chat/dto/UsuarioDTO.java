package com.ranyell.chat.dto;

import java.io.Serializable;

import com.ranyell.chat.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String nome;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.nome = obj.getNome();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
