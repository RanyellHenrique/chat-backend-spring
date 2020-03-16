package com.ranyell.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranyell.chat.domain.Conversa;

public interface ConversaRepository  extends JpaRepository<Conversa, Integer>{

}
