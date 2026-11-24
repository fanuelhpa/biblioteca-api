package com.fandevv.biblioteca.dto;

import com.fandevv.biblioteca.entities.Usuario;
import com.fandevv.biblioteca.enums.StatusUsuario;

public class UsuarioRequestDTO {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private StatusUsuario status;

    public UsuarioRequestDTO() {

    }

    public UsuarioRequestDTO(String nome, String email, String telefone, String cpf, StatusUsuario status) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.status = status;
    }

    public UsuarioRequestDTO(Usuario entity) {
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        cpf = entity.getCpf();
        status = entity.getStatus();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public StatusUsuario getStatus() {
        return status;
    }
}
