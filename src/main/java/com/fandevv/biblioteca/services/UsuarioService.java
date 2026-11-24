package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.UsuarioEmprestimoDTO;
import com.fandevv.biblioteca.dto.UsuarioRequestDTO;
import com.fandevv.biblioteca.dto.UsuarioResponseDTO;
import com.fandevv.biblioteca.entities.Usuario;
import com.fandevv.biblioteca.enums.StatusUsuario;
import com.fandevv.biblioteca.projections.UsuarioEmprestimoProjection;
import com.fandevv.biblioteca.repositories.UsuarioRepository;
import com.fandevv.biblioteca.services.exceptions.DatabaseException;
import com.fandevv.biblioteca.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<UsuarioEmprestimoDTO> searchEmprestimosById(Long id) {
        List<UsuarioEmprestimoProjection> listProjection = repository.searchEmprestimosById(id);
        if(listProjection.isEmpty()) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        List<UsuarioEmprestimoDTO> listDto = listProjection.stream().map(x -> new UsuarioEmprestimoDTO(x)).collect(Collectors.toList());
        return listDto;
    }

    @Transactional
    public UsuarioResponseDTO insert(UsuarioRequestDTO requestDto) {
       try {
           Usuario usuario = new Usuario();
           usuario.setNome(requestDto.getNome());
           usuario.setEmail(requestDto.getEmail());
           usuario.setTelefone(requestDto.getTelefone());
           usuario.setCpf(requestDto.getCpf());
           usuario.setStatus(requestDto.getStatus());
           usuario = repository.save(usuario);
           return new UsuarioResponseDTO(usuario);
       }catch(DataIntegrityViolationException e) {
           throw new DatabaseException("Email e/ou CPF já cadastrados no sistema");
       }
    }

    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO requestDTO) {
        try {
            Usuario usuario = repository.getReferenceById(id);
            usuario.setNome(requestDTO.getNome());
            usuario.setEmail(requestDTO.getEmail());
            usuario.setTelefone(requestDTO.getTelefone());
            usuario.setStatus(requestDTO.getStatus());
            usuario = repository.save(usuario);
            return new UsuarioResponseDTO(usuario);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }
}
