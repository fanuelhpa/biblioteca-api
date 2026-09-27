package com.fandevv.biblioteca.enums;

public enum StatusEmprestimo {
    
    ATIVO(0),
    DEVOLVIDO(1),
    ATRASADO(2);

    private final int codigo;

    StatusEmprestimo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusEmprestimo fromCodigo(int codigo) {
        for (StatusEmprestimo status : StatusEmprestimo.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}