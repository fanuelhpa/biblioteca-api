package com.fandevv.biblioteca.projections;

import com.fandevv.biblioteca.enums.StatusEmprestimo;

import java.time.LocalDate;

public interface UsuarioEmprestimoProjection {

    String getNomeUsuario();
    String getTituloLivro();
    LocalDate getDataEmprestimo();
    LocalDate getDataPrevistaDevolucao();
    LocalDate getDataDevolucao();
    Integer getStatusEmprestimo();
}
