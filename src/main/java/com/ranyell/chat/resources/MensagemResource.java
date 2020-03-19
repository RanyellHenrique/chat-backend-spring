package com.ranyell.chat.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ranyell.chat.domain.Mensagem;
import com.ranyell.chat.services.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemResource {
	
	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Mensagem> findById(@PathVariable Integer id){
		Mensagem obj = mensagemService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Mensagem obj){
		obj = mensagemService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		mensagemService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @PathVariable Integer id, @RequestBody Mensagem obj){
		obj.setId(id);
		obj = mensagemService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page<Mensagem>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<Mensagem> list = mensagemService.findPage(page, linesPerPage, orderBy, direction);
		//Page<UsuarioDTO> listDto = list.map(obj -> new UsuarioDTO(obj));
		return ResponseEntity.ok().body(list);
	}

}
