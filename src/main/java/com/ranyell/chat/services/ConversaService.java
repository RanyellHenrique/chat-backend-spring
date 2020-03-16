package com.ranyell.chat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Conversa;
import com.ranyell.chat.repositories.ConversaRepository;
import com.ranyell.chat.services.exceptions.ObjectNotFoundException;

@Service
public class ConversaService {
	
	@Autowired
	private ConversaRepository conversaRepository;

	public Conversa findById(Integer id) {
		Optional<Conversa> obj = conversaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Conversa não encontrada Id: " + id + ",tipo: " + Conversa.class.getName()));
	}
}
