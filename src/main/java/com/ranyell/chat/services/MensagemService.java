package com.ranyell.chat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Mensagem;
import com.ranyell.chat.repositories.MensagemRepository;
import com.ranyell.chat.services.exceptions.DataIntegrityException;
import com.ranyell.chat.services.exceptions.ObjectNotFoundException;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;

	public Mensagem findById(Integer id) {
		Optional<Mensagem> obj = mensagemRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Mensagem não encontrada Id: " + id + ",tipo: " + Mensagem.class.getName()));
	}
	
	public Mensagem insert(Mensagem obj) {
		return mensagemRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			mensagemRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Mensagem não pode ser excluido.");
		}
	}
	
	public Mensagem update(Mensagem obj) {
		findById(obj.getId());
		return mensagemRepository.save(obj);
	}
}
