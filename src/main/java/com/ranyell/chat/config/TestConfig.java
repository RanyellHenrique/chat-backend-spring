package com.ranyell.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ranyell.chat.domain.Usuario;
import com.ranyell.chat.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario s1 = new Usuario(null, "ranyellheneique@gmail.com", "Ranyell Henrique dos Santos", "123");
		usuarioRepository.save(s1);
		
	}

}
