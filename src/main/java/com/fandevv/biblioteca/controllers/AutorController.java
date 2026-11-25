package com.fandevv.biblioteca.controllers;

import com.fandevv.biblioteca.dto.AutorDTO;
import com.fandevv.biblioteca.entities.Autor;
import com.fandevv.biblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAll() {
        List<AutorDTO> listDto = service.findAll();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable Long id) {
        AutorDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> insert(@RequestBody AutorDTO autorDTO) {
        autorDTO = service.insert(autorDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(autorDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(autorDTO);
    }
}
