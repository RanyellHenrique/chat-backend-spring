package com.ranyell.chat.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranyell.chat.domain.Mensagem;
import com.ranyell.chat.services.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemResource {
	
	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Mensagem> findById(@PathVariable Integer id){
		Mensagem obj = mensagemService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
