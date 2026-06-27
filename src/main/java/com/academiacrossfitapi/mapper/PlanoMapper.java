package com.academiacrossfitapi.mapper;

import com.academiacrossfitapi.dto.PlanoRequestDTO;
import com.academiacrossfitapi.dto.PlanoResponseDTO;
import com.academiacrossfitapi.model.Plano;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanoMapper {

    @Mapping(target = "treinos", ignore = true)
    Plano toEntity(PlanoRequestDTO dto);

    @Mapping(target = "treinosId", source = "treinos.id")
    PlanoResponseDTO toResponseDTO(Plano entity);
}
