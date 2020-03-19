package com.ranyell.chat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
		Usuario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return usuarioRepository.save(newObj);
	}

	public List<Usuario> findAll(){
		List<Usuario> obj = usuarioRepository.findAll();
		return obj;
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pagRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.findAll(pagRequest);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setNome(obj.getNome());
	}
}
