package com.ranyell.chat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Usuario;
import com.ranyell.chat.repositories.UsuarioRepository;
import com.ranyell.chat.services.exceptions.DataIntegrityException;
import com.ranyell.chat.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrada Id: " + id + ",tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj); 
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			usuarioRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Usuario não pode ser excluido.");
		}
	}
	
	public Usuario update(Usuario obj) {
		findById(obj.getId());
		return usuarioRepository.save(obj);
	}
}
