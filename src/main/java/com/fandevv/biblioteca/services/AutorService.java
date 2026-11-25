package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.AutorResponseDTO;
import com.fandevv.biblioteca.entities.Autor;
import com.fandevv.biblioteca.repositories.AutorRepository;
import com.fandevv.biblioteca.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    @Transactional(readOnly = true)
    public List<AutorResponseDTO> findAll() {

        List<Autor> result = repository.findAll();
        List<AutorResponseDTO> listDto = result.stream().map(x -> new AutorResponseDTO(x)).toList();
        return listDto;
    }

    @Transactional(readOnly = true)
    public AutorResponseDTO findById(Long id) {
        Autor autor = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Recurso não encontrado"));
        return new AutorResponseDTO(autor);
    }
}
