package com.fandevv.biblioteca.controllers;

import com.fandevv.biblioteca.dto.UsuarioEmprestimoDTO;
import com.fandevv.biblioteca.dto.UsuarioRequestDTO;
import com.fandevv.biblioteca.dto.UsuarioResponseDTO;
import com.fandevv.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> findAll(Pageable pageable) {
        Page<UsuarioResponseDTO> result = service.findAll(pageable);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        UsuarioResponseDTO result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}/emprestimos")
    public ResponseEntity<List<UsuarioEmprestimoDTO>> searchEmprestimosById(@PathVariable Long id){
        List<UsuarioEmprestimoDTO> dto = service.searchEmprestimosById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> insert(@RequestBody UsuarioRequestDTO requestDTO){
        UsuarioResponseDTO responseDTO = service.insert(requestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(responseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }
}
