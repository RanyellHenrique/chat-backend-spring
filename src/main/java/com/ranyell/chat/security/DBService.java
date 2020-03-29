package com.ranyell.chat.security;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ranyell.chat.domain.Usuario;
import com.ranyell.chat.domain.enuns.Perfil;
import com.ranyell.chat.repositories.ConversaRepository;
import com.ranyell.chat.repositories.MensagemRepository;
import com.ranyell.chat.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ConversaRepository conversaRepository;
	
	@Autowired
	private MensagemRepository mensagemRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario s1 = new Usuario(null, "ranyell@gmail.com", "Ranyell", pe.encode("12345"));
		s1.addPerfil(Perfil.ADMIN);
		Usuario s2 = new Usuario(null, "edmilson@gmail.com", "José Silva", pe.encode("12345"));
		Usuario s3 = new Usuario(null, "Will@gmail.com", "Wilson", pe.encode("12345"));
		Usuario s4 = new Usuario(null, "rafaela@gmail.com", "Rafaela", pe.encode("12345"));
		Usuario s5 = new Usuario(null, "eduarda@gmail.com", "Eduarda", pe.encode("12345"));
		Usuario s6 = new Usuario(null, "willian@gmail.com", "Willian", pe.encode("12345"));
		Usuario s7 = new Usuario(null, "daniel@gmail.com", "Daniel", pe.encode("12345"));
		Usuario s8 = new Usuario(null, "fabio@gmail.com", "Fabio", pe.encode("12345"));
		Usuario s9 = new Usuario(null, "ana@gmail.com", "Ana Julia", pe.encode("12345"));
		
		
		usuarioRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9));
	}

}
