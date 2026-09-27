package com.fandevv.biblioteca.repositories;

import com.fandevv.biblioteca.entities.Usuario;
import com.fandevv.biblioteca.projections.UsuarioEmprestimoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(nativeQuery = true, value = "SELECT tb_usuario.nome AS nomeUsuario, tb_livro.titulo AS tituloLivro, tb_emprestimo.data_emprestimo AS dataEmprestimo, tb_emprestimo.data_prevista_devolucao AS dataPrevistaDevolucao, tb_emprestimo.data_devolucao AS dataDevolucao, tb_emprestimo.status AS statusEmprestimo " +
           "FROM tb_usuario INNER JOIN tb_emprestimo ON tb_usuario.id = tb_emprestimo.usuario_id INNER JOIN tb_livro ON tb_emprestimo.livro_id = tb_livro.id WHERE " +
            " tb_usuario.id = :id")
    List<UsuarioEmprestimoProjection> searchEmprestimosById(Long id);
}
