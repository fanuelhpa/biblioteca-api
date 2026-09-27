package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.UsuarioResponseDTO;
import com.fandevv.biblioteca.entities.Usuario;
import com.fandevv.biblioteca.repositories.UsuarioRepository;
import com.fandevv.biblioteca.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {
        Page<Usuario> pageUsuario = repository.findAll(pageable);
        Page<UsuarioResponseDTO> pageUsuarioResponseDTO = pageUsuario.map(x -> new UsuarioResponseDTO(x));
        return pageUsuarioResponseDTO;
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new UsuarioResponseDTO(usuario);
    }
}
