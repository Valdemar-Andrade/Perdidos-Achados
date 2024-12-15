package com.ucan.perdidosachados.repository;

import com.ucan.perdidosachados.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByTelefone(String telefone);

}
