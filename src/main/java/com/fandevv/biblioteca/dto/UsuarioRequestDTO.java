package com.fandevv.biblioteca.dto;

import com.fandevv.biblioteca.entities.Usuario;

public class UsuarioRequestDTO {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public UsuarioRequestDTO() {

    }

    public UsuarioRequestDTO(String nome, String email, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public UsuarioRequestDTO(Usuario entity) {
        nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.cpf = entity.getCpf();
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
}
