package com.ranyell.chat.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranyell.chat.domain.Conversa;
import com.ranyell.chat.services.ConversaService;

@RestController
@RequestMapping("/conversas")
public class ConversaResource {
	
	@Autowired
	private ConversaService conversaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conversa> findById(@PathVariable Integer id){
		Conversa obj = conversaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
