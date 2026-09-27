package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.UsuarioResponseDTO;
import com.fandevv.biblioteca.entities.Usuario;
import com.fandevv.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {
        Page<Usuario> pageUsuario = repository.findAll(pageable);
        Page<UsuarioResponseDTO> pageUsuarioResponseDTO = pageUsuario.map(x -> new UsuarioResponseDTO(x));
        return pageUsuarioResponseDTO;
    }
}
