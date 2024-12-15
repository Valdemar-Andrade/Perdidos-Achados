package com.ucan.perdidosachados.service;

import com.ucan.perdidosachados.entities.Usuario;
import com.ucan.perdidosachados.repository.UsuarioRepository;
import com.ucan.perdidosachados.utils.UsuarioDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String telefone) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByTelefone(telefone);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new UsuarioDetails(usuario.get());
    }
}
