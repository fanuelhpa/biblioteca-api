package com.fandevv.biblioteca.dto;

import com.fandevv.biblioteca.entities.Autor;

public class AutorDTO {

    private Long id;
    private String nome;
    private String nacionalidade;

    public AutorDTO() {

    }

    public AutorDTO(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public AutorDTO(Autor entity) {
        id = entity.getId();
        nome = entity.getNome();
        nacionalidade = entity.getNacionalidade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
