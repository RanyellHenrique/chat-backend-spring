package com.ranyell.chat.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Void> insert(@RequestBody Mensagem obj){
		obj = mensagemService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
