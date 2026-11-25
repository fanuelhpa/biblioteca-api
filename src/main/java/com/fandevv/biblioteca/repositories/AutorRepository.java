package com.fandevv.biblioteca.repositories;

import com.fandevv.biblioteca.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
