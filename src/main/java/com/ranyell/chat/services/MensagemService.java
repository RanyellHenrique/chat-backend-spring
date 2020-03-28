package com.ranyell.chat.services;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Mensagem;
import com.ranyell.chat.repositories.MensagemRepository;
import com.ranyell.chat.services.exceptions.DataIntegrityException;
import com.ranyell.chat.services.exceptions.ObjectNotFoundException;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ConversaService conversaService;

	public Mensagem findById(Integer id) {
		Optional<Mensagem> obj = mensagemRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Mensagem não encontrada Id: " + id + ",tipo: " + Mensagem.class.getName()));
	}
	
	@Transactional
	public Mensagem insert(Mensagem obj) {
		obj.setConversa(conversaService.findById(obj.getConversa().getId()));
		obj.setUsuario(usuarioService.findById(obj.getUsuario().getId()));
		obj.setData(new Date());
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
	
	public Page<Mensagem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pagRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return mensagemRepository.findAll(pagRequest);
	}
	
	public List<Mensagem> findAll(){
		List<Mensagem> obj = mensagemRepository.findAll();
		return obj;
	}
}
