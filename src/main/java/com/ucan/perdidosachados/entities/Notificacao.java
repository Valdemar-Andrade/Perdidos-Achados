package com.ucan.perdidosachados.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Notificacao")
public class Notificacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID pk;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mensagem;

    @Column
    private LocalDateTime dataEnviado;

    @Column
    private boolean enviado;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnviado() {
        return dataEnviado;
    }

    public void setDataEnviado(LocalDateTime dataEnviado) {
        this.dataEnviado = dataEnviado;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }
}
