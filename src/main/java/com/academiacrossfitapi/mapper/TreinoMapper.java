package com.academiacrossfitapi.mapper;

import com.academiacrossfitapi.dto.TreinoRequestDTO;
import com.academiacrossfitapi.dto.TreinoResponseDTO;
import com.academiacrossfitapi.model.Treino;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreinoMapper {

    Treino toEntity(TreinoRequestDTO dto);

    TreinoResponseDTO toResponseDTO(Treino entity);
}
