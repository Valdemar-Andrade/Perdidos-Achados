package com.ucan.perdidosachados.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Documento")
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID pk;

    @Column
    private String tipo;

    @Column
    private String nomeProprietario;

    @Column
    private LocalDate dataEncontrado;

    @Column
    private String localizacaoEncontrado;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "encontrado_por", referencedColumnName = "pk")
    private Usuario encontradoPor;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public LocalDate getDataEncontrado() {
        return dataEncontrado;
    }

    public void setDataEncontrado(LocalDate dataEncontrado) {
        this.dataEncontrado = dataEncontrado;
    }

    public String getLocalizacaoEncontrado() {
        return localizacaoEncontrado;
    }

    public void setLocalizacaoEncontrado(String localizacaoEncontrado) {
        this.localizacaoEncontrado = localizacaoEncontrado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getEncontradoPor() {
        return encontradoPor;
    }

    public void setEncontradoPor(Usuario encontradoPor) {
        this.encontradoPor = encontradoPor;
    }
}
