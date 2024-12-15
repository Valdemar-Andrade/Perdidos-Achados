package com.ucan.perdidosachados.controller;

import com.ucan.perdidosachados.utils.UsuarioDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
            String nomeUsuario = usuarioDetails.getNome();

            model.addAttribute("nomeUsuario", nomeUsuario);
        }

        return "home";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UsuarioDetails) {
            UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
            String nomeUsuario = usuarioDetails.getNome();

            model.addAttribute("nomeUsuario", nomeUsuario);
            model.addAttribute("emailUsuario", usuarioDetails.getEmail());
            model.addAttribute("telefoneUsuario", usuarioDetails.getUsername());
        }

        return "perfil";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
