package com.academiacrossfitapi.service;

import com.academiacrossfitapi.dto.TreinoRequestDTO;
import com.academiacrossfitapi.dto.TreinoResponseDTO;
import com.academiacrossfitapi.exception.ResourceNotFoundException;
import com.academiacrossfitapi.mapper.TreinoMapper;
import com.academiacrossfitapi.model.Treino;
import com.academiacrossfitapi.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    @Autowired
    private TreinoMapper mapper;

    @Transactional(readOnly = true)
    public List<TreinoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TreinoResponseDTO buscar(Long id) {
        Treino entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public TreinoResponseDTO criar(TreinoRequestDTO dto) {
        Treino entity = mapper.toEntity(dto);
        Treino salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public TreinoResponseDTO atualizar(Long id, TreinoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Treino não encontrado com id: " + id);
        }
        Treino entity = mapper.toEntity(dto);
        entity.setId(id);
        Treino salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Treino não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
