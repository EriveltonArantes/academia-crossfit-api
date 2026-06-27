package com.academiacrossfitapi.service;

import com.academiacrossfitapi.dto.AtletaRequestDTO;
import com.academiacrossfitapi.dto.AtletaResponseDTO;
import com.academiacrossfitapi.exception.ResourceNotFoundException;
import com.academiacrossfitapi.mapper.AtletaMapper;
import com.academiacrossfitapi.model.Atleta;
import com.academiacrossfitapi.repository.AtletaRepository;
import com.academiacrossfitapi.repository.PlanoRepository;
import com.academiacrossfitapi.model.Plano;
import com.academiacrossfitapi.repository.TreinoRepository;
import com.academiacrossfitapi.model.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AtletaService {

    @Autowired
    private AtletaRepository repository;

    @Autowired
    private AtletaMapper mapper;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    @Transactional(readOnly = true)
    public List<AtletaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AtletaResponseDTO buscar(Long id) {
        Atleta entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AtletaResponseDTO criar(AtletaRequestDTO dto) {
        Atleta entity = mapper.toEntity(dto);
        Plano plano = planoRepository.findById(dto.getPlanoId())
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com id: " + dto.getPlanoId()));
        entity.setPlano(plano);
        Treino treino = treinoRepository.findById(dto.getTreinoId())
            .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com id: " + dto.getTreinoId()));
        entity.setTreino(treino);
        Atleta salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AtletaResponseDTO atualizar(Long id, AtletaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Atleta não encontrado com id: " + id);
        }
        Atleta entity = mapper.toEntity(dto);
        entity.setId(id);
        Plano plano = planoRepository.findById(dto.getPlanoId())
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com id: " + dto.getPlanoId()));
        entity.setPlano(plano);
        Treino treino = treinoRepository.findById(dto.getTreinoId())
            .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado com id: " + dto.getTreinoId()));
        entity.setTreino(treino);
        Atleta salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Atleta não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
