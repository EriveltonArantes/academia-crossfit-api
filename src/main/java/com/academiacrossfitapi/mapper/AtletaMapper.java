package com.academiacrossfitapi.mapper;

import com.academiacrossfitapi.dto.AtletaRequestDTO;
import com.academiacrossfitapi.dto.AtletaResponseDTO;
import com.academiacrossfitapi.model.Atleta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AtletaMapper {

    @Mapping(target = "plano", ignore = true)
    @Mapping(target = "treino", ignore = true)
    Atleta toEntity(AtletaRequestDTO dto);

    @Mapping(target = "planoId", source = "plano.id")
    @Mapping(target = "treinoId", source = "treino.id")
    AtletaResponseDTO toResponseDTO(Atleta entity);
}
