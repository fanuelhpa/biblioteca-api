package com.fandevv.biblioteca.entities;

import com.fandevv.biblioteca.enums.StatusReserva;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo data de reserva obrigatório")
    private LocalDate dataReserva;

    @NotNull(message = "Campo data de expiração obrigatório")
    private LocalDate dataExpiracao;

    private StatusReserva status;

    @NotNull(message = "Campo usuário obrigatório")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotNull(message = "Campo livro obrigatório")
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Reserva() {

    }

    public Reserva(Long id, LocalDate dataReserva, LocalDate dataExpiracao, StatusReserva status, Usuario usuario, Livro livro) {
        this.id = id;
        this.dataReserva = dataReserva;
        this.dataExpiracao = dataExpiracao;
        this.status = status;
        this.usuario = usuario;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
