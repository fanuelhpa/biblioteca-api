package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.AutorDTO;
import com.fandevv.biblioteca.entities.Autor;
import com.fandevv.biblioteca.repositories.AutorRepository;
import com.fandevv.biblioteca.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    @Transactional(readOnly = true)
    public List<AutorDTO> findAll() {

        List<Autor> result = repository.findAll();
        List<AutorDTO> listDto = result.stream().map(x -> new AutorDTO(x)).toList();
        return listDto;
    }

    @Transactional(readOnly = true)
    public AutorDTO findById(Long id) {
        Autor autor = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Recurso não encontrado"));
        return new AutorDTO(autor);
    }

    @Transactional
    public AutorDTO insert(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setId(autorDTO.getId());
        autor.setNome(autorDTO.getNome());
        autor.setNacionalidade(autorDTO.getNacionalidade());
        autor = repository.save(autor);
        return new AutorDTO(autor);
    }
}
