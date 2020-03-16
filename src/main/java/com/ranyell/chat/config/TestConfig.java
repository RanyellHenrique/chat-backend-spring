package com.ranyell.chat.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ranyell.chat.domain.Conversa;
import com.ranyell.chat.domain.Mensagem;
import com.ranyell.chat.domain.Usuario;
import com.ranyell.chat.repositories.ConversaRepository;
import com.ranyell.chat.repositories.MensagemRepository;
import com.ranyell.chat.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ConversaRepository conversaRepository;
	
	@Autowired
	private MensagemRepository mensagemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario s1 = new Usuario(null, "ranyellheneique@gmail.com", "Ranyell Henrique dos Santos", "123");
		Usuario s2 = new Usuario(null, "Edmilson@gmail.com", "Edmilson pé de fava", "123");
		Usuario s3 = new Usuario(null, "Will@gmail.com", "Will Smith", "123");
		
		Conversa c1 = new Conversa(null);
		Conversa c2 = new Conversa(null);
		
		s1.getConversas().addAll(Arrays.asList(c1));
		s2.getConversas().addAll(Arrays.asList(c1, c2));
		s3.getConversas().addAll(Arrays.asList(c2));
		
		c1.getUsuarios().addAll(Arrays.asList(s1, s2));
		c2.getUsuarios().addAll(Arrays.asList(s3, s2));
		
		Mensagem m1 = new Mensagem(null, "Olá, tudo bem!", sdf.parse("27/10/2020 20:30"), c1, s1);
		Mensagem m2 = new Mensagem(null, "Oi", sdf.parse("27/10/2020 20:35"), c1, s2);
		Mensagem m3 = new Mensagem(null, "Fala Zezé, bom dia cara.", sdf.parse("27/10/2020 20:30"), c2, s2);
		Mensagem m4 = new Mensagem(null, "Deixa eu te falar", sdf.parse("27/10/2020 20:30"), c2, s3);
		
		c1.getMensagens().addAll(Arrays.asList(m1, m2));
		c1.getMensagens().addAll(Arrays.asList(m3, m4));
		
		usuarioRepository.saveAll(Arrays.asList(s1, s2, s3));
		conversaRepository.saveAll(Arrays.asList(c1, c2));
		mensagemRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
	}

}
