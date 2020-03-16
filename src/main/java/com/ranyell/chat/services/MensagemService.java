package com.ranyell.chat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Mensagem;
import com.ranyell.chat.repositories.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;

	public Mensagem findById(Integer id) {
		Optional<Mensagem> obj = mensagemRepository.findById(id);
		return obj.get();
	}
}
