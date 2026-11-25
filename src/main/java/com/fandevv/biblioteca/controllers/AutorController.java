package com.fandevv.biblioteca.controllers;

import com.fandevv.biblioteca.dto.AutorResponseDTO;
import com.fandevv.biblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> findAll() {
        List<AutorResponseDTO> listDto = service.findAll();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable Long id) {
        AutorResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
}
