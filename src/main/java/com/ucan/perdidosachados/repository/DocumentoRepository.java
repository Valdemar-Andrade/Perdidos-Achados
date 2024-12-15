package com.ucan.perdidosachados.repository;

import com.ucan.perdidosachados.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<Documento, UUID> {



}
