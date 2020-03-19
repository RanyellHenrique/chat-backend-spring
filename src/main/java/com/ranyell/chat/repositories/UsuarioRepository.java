package com.ranyell.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranyell.chat.domain.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

	Usuario findByEmail(String email);
	
}
