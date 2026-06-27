package com.academiacrossfitapi.service;

import com.academiacrossfitapi.dto.MatriculaRequestDTO;
import com.academiacrossfitapi.dto.MatriculaResponseDTO;
import com.academiacrossfitapi.exception.ResourceNotFoundException;
import com.academiacrossfitapi.mapper.MatriculaMapper;
import com.academiacrossfitapi.model.Matricula;
import com.academiacrossfitapi.repository.MatriculaRepository;
import com.academiacrossfitapi.repository.AtletaRepository;
import com.academiacrossfitapi.model.Atleta;
import com.academiacrossfitapi.repository.PlanoRepository;
import com.academiacrossfitapi.model.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private MatriculaMapper mapper;

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MatriculaResponseDTO buscar(Long id) {
        Matricula entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public MatriculaResponseDTO criar(MatriculaRequestDTO dto) {
        Matricula entity = mapper.toEntity(dto);
        Atleta atleta = atletaRepository.findById(dto.getAtletaId())
            .orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado com id: " + dto.getAtletaId()));
        entity.setAtleta(atleta);
        Plano plano = planoRepository.findById(dto.getPlanoId())
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com id: " + dto.getPlanoId()));
        entity.setPlano(plano);
        Matricula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public MatriculaResponseDTO atualizar(Long id, MatriculaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula não encontrado com id: " + id);
        }
        Matricula entity = mapper.toEntity(dto);
        entity.setId(id);
        Atleta atleta = atletaRepository.findById(dto.getAtletaId())
            .orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado com id: " + dto.getAtletaId()));
        entity.setAtleta(atleta);
        Plano plano = planoRepository.findById(dto.getPlanoId())
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com id: " + dto.getPlanoId()));
        entity.setPlano(plano);
        Matricula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
