package com.example.familia_api.modelos.mapas;

import com.example.familia_api.modelos.Vinculo;
import com.example.familia_api.modelos.dto.VinculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaVinculo {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "estudiante.id", target = "estudianteId")
    @Mapping(source = "familiar.id", target = "familiarId")
    @Mapping(source = "parentesco", target = "parentesco")
    VinculoDTO toDto(Vinculo vinculo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estudiante", ignore = true) // Se manejará en el servicio
    @Mapping(target = "familiar", ignore = true)   // Se manejará en el servicio
    Vinculo toEntity(VinculoDTO dto);

    List<VinculoDTO> toDtoList(List<Vinculo> vinculos);
}
