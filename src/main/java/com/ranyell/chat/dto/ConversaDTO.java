package com.ranyell.chat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ranyell.chat.domain.Conversa;
import com.ranyell.chat.domain.Usuario;

public class ConversaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private List<UsuarioDTO> usuarios = new ArrayList<>();
	
	public ConversaDTO() {
		
	}
	
	public ConversaDTO(Conversa obj) {
		this.id = obj.getId();
		for(Usuario u : obj.getUsuarios()) {
			usuarios.add(new UsuarioDTO(u));
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}



}
