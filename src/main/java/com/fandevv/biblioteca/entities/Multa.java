package com.fandevv.biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_multa")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo valor obrigatório")
    private Double valor;

    private boolean pago = false;
    private LocalDate dataPagamento;

    @OneToOne
    @MapsId
    private Emprestimo emprestimo;

    public Multa() {

    }

    public Multa(Long id, Double valor, boolean pago, LocalDate dataPagamento, Emprestimo emprestimo) {
        this.id = id;
        this.valor = valor;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
        this.emprestimo = emprestimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Multa multa = (Multa) o;
        return Objects.equals(id, multa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
