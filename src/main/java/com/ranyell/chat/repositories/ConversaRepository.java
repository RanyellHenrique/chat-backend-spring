package com.ranyell.chat.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ranyell.chat.domain.Conversa;
import com.ranyell.chat.domain.Usuario;

public interface ConversaRepository extends JpaRepository<Conversa, Integer> {

	@Transactional(readOnly = true)
	Page<Conversa> findByUsuarios(Usuario usuario, Pageable pageRequest);
}