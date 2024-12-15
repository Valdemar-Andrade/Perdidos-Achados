package com.ucan.perdidosachados.service;

import com.ucan.perdidosachados.entities.Usuario;
import com.ucan.perdidosachados.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<Usuario> criarConta(Usuario usuario){

        usuario.setTipoUsuario("normal");
        usuario.setBloqueado(false);

        // Armazena a senha como um hash
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        return Optional.of( usuarioRepository.save(usuario) );

    }

   public Optional<Usuario> atualizarPerfil(Usuario usuario){

        Optional<Usuario> usuarioAntigo = usuarioRepository.findByTelefone(usuario.getTelefone());

       if (usuarioAntigo.isPresent()){

           usuarioAntigo.get().setNome(usuario.getNome());
           usuarioAntigo.get().setEmail(usuario.getEmail());
           usuarioAntigo.get().setTelefone(usuario.getTelefone());

           return  Optional.of(usuarioRepository.save(usuarioAntigo.get()));

       }else {
           return Optional.empty();
       }

   }

}
