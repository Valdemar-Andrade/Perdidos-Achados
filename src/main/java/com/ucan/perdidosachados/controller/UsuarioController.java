package com.ucan.perdidosachados.controller;

import com.ucan.perdidosachados.entities.Usuario;
import com.ucan.perdidosachados.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/conta")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar-conta")
    public String criarConta(@ModelAttribute("usuario") Usuario usuario, Model model){

        model.addAttribute("cadastro", "true");

        if( usuarioService.criarConta(usuario).isPresent() ){
            model.addAttribute("mensagem", "Cadastrado com Sucesso!");
        }else {
            model.addAttribute("mensagem", "Erro ao efetuar cadastro!");
        }

        return "login";
    }

    @PostMapping("/atualizar-perfil")
    public String atualizarPerfil(@ModelAttribute("usuario") Usuario usuario, Model model){

        if (usuarioService.atualizarPerfil(usuario).isPresent()){
            model.addAttribute("nomeUsuario", usuario.getNome());
            model.addAttribute("emailUsuario", usuario.getEmail());
            model.addAttribute("telefoneUsuario", usuario.getTelefone());
        }else {
            model.addAttribute("mensagem", "Não foi possível atualizar os dados");
        }

        return "perfil";
    }

}
