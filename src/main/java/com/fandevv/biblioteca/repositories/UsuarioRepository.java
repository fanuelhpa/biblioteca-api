package com.fandevv.biblioteca.repositories;

import com.fandevv.biblioteca.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
