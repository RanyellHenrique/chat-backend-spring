package com.ranyell.chat.dto;

import java.io.Serializable;
import java.util.Date;

import com.ranyell.chat.domain.Mensagem;

public class MensagemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String conteudo;
	private Date data;
	private Integer usuario;
	private Integer conversa;
	
	public MensagemDTO(){
		
	}
	
	public MensagemDTO(Mensagem obj) {
		this.id = obj.getId();
		this.conteudo = obj.getConteudo();
		this.data = obj.getData();
		this.usuario = obj.getUsuario().getId();
		this.conversa = obj.getConversa().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getConversa() {
		return conversa;
	}

	public void setConversa(Integer conversa) {
		this.conversa = conversa;
	}
}
