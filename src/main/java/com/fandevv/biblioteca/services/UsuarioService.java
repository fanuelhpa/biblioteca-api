package com.fandevv.biblioteca.services;

import com.fandevv.biblioteca.dto.UsuarioEmprestimoDTO;
import com.fandevv.biblioteca.dto.UsuarioRequestDTO;
import com.fandevv.biblioteca.dto.UsuarioResponseDTO;
import com.fandevv.biblioteca.entities.Usuario;
import com.fandevv.biblioteca.enums.StatusUsuario;
import com.fandevv.biblioteca.projections.UsuarioEmprestimoProjection;
import com.fandevv.biblioteca.repositories.UsuarioRepository;
import com.fandevv.biblioteca.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<UsuarioEmprestimoDTO> listDto = listProjection.stream().map(x -> new UsuarioEmprestimoDTO(x)).collect(Collectors.toList());
        return listDto;
    }

    @Transactional
    public UsuarioResponseDTO insert(UsuarioRequestDTO requestDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(requestDto.getNome());
        usuario.setEmail(requestDto.getEmail());
        usuario.setTelefone(requestDto.getTelefone());
        usuario.setCpf(requestDto.getCpf());
        usuario.setStatus(StatusUsuario.ATIVO);

        usuario = repository.save(usuario);

        return new UsuarioResponseDTO(usuario);
    }
}
