package com.academiacrossfitapi.service;

import com.academiacrossfitapi.dto.PlanoRequestDTO;
import com.academiacrossfitapi.dto.PlanoResponseDTO;
import com.academiacrossfitapi.exception.ResourceNotFoundException;
import com.academiacrossfitapi.mapper.PlanoMapper;
import com.academiacrossfitapi.model.Plano;
import com.academiacrossfitapi.repository.PlanoRepository;
import com.academiacrossfitapi.repository.TreinoRepository;
import com.academiacrossfitapi.model.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanoService {

    @Autowired
    private PlanoRepository repository;

    @Autowired
    private PlanoMapper mapper;

    @Autowired
    private TreinoRepository treinosRepository;

    @Transactional(readOnly = true)
    public List<PlanoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlanoResponseDTO buscar(Long id) {
        Plano entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PlanoResponseDTO criar(PlanoRequestDTO dto) {
        Plano entity = mapper.toEntity(dto);
        Treino treinos = treinosRepository.findById(dto.getTreinosId())
            .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com id: " + dto.getTreinosId()));
        entity.setTreinos(treinos);
        Plano salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PlanoResponseDTO atualizar(Long id, PlanoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Plano não encontrado com id: " + id);
        }
        Plano entity = mapper.toEntity(dto);
        entity.setId(id);
        Treino treinos = treinosRepository.findById(dto.getTreinosId())
            .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com id: " + dto.getTreinosId()));
        entity.setTreinos(treinos);
        Plano salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Plano não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
