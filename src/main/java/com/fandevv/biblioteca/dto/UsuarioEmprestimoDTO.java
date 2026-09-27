package com.fandevv.biblioteca.dto;

import com.fandevv.biblioteca.enums.StatusEmprestimo;
import com.fandevv.biblioteca.projections.UsuarioEmprestimoProjection;

import java.time.LocalDate;

public class UsuarioEmprestimoDTO {

    private String nomeUsuario;
    private String tituloLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private StatusEmprestimo statusEmprestimo;

    public UsuarioEmprestimoDTO() {

    }

    public UsuarioEmprestimoDTO(String nomeUsuario, String tituloLivro, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, LocalDate dataDevolucao, StatusEmprestimo statusEmprestimo) {
        this.nomeUsuario = nomeUsuario;
        this.tituloLivro = tituloLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.statusEmprestimo = statusEmprestimo;
    }

    public UsuarioEmprestimoDTO(UsuarioEmprestimoProjection projection) {

        nomeUsuario = projection.getNomeUsuario();
        tituloLivro = projection.getTituloLivro();
        dataEmprestimo = projection.getDataEmprestimo();
        dataPrevistaDevolucao = projection.getDataPrevistaDevolucao();
        dataDevolucao = projection.getDataDevolucao();
        statusEmprestimo = StatusEmprestimo.fromCodigo(projection.getStatusEmprestimo()) ;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }
}
