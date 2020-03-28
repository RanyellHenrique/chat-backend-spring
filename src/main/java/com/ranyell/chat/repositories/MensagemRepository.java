package com.ranyell.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranyell.chat.domain.Mensagem;

public interface MensagemRepository  extends JpaRepository<Mensagem, Integer>{

	
}
