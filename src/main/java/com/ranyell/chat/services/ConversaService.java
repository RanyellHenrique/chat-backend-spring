package com.ranyell.chat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Conversa;
import com.ranyell.chat.domain.Usuario;
import com.ranyell.chat.repositories.ConversaRepository;
import com.ranyell.chat.security.UserSS;
import com.ranyell.chat.services.exceptions.AuthorizationException;
import com.ranyell.chat.services.exceptions.DataIntegrityException;
import com.ranyell.chat.services.exceptions.ObjectNotFoundException;

@Service
public class ConversaService {
	
	@Autowired
	private ConversaRepository conversaRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public Conversa findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null || user.getId() != id ) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Conversa> obj = conversaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Conversa não encontrada Id: " + id + ",tipo: " + Conversa.class.getName()));
	}
	
	public Conversa insert(Conversa obj) {
		return conversaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			conversaRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir essa conversa");
		}
	}
	
	public Conversa update(Conversa obj) {
		findById(obj.getId());
		return conversaRepository.save(obj);
	}
	
	public Page<Conversa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Usuario usuario =  usuarioService.findById(user.getId());
		return conversaRepository.findByUsuarios(usuario, pageRequest);
	}
}
