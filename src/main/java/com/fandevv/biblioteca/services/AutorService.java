package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.AutorResponseDTO;
import com.fandevv.biblioteca.entities.Autor;
import com.fandevv.biblioteca.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    @Transactional(readOnly = true)
    public List<AutorResponseDTO> findAll() {

        List<Autor> result = repository.findAll();
        List<AutorResponseDTO> listDto = result.stream().map(x -> new AutorResponseDTO(x)).toList();

        if(listDto.isEmpty()) {
            System.out.println("vazio");
        }

        return listDto;
    }
}
