package com.ucan.perdidosachados.repository;

import com.ucan.perdidosachados.entities.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {



}
