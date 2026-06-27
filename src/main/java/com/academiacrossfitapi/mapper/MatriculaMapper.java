package com.academiacrossfitapi.mapper;

import com.academiacrossfitapi.dto.MatriculaRequestDTO;
import com.academiacrossfitapi.dto.MatriculaResponseDTO;
import com.academiacrossfitapi.model.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    @Mapping(target = "atleta", ignore = true)
    @Mapping(target = "plano", ignore = true)
    Matricula toEntity(MatriculaRequestDTO dto);

    @Mapping(target = "atletaId", source = "atleta.id")
    @Mapping(target = "planoId", source = "plano.id")
    MatriculaResponseDTO toResponseDTO(Matricula entity);
}
