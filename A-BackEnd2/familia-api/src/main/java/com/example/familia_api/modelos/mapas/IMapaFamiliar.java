package com.example.familia_api.modelos.mapas;

import com.example.familia_api.ayudas.Rol;
import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.dto.FamiliarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaFamiliar {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(target = "rol", expression = "java(com.example.familia_api.ayudas.Rol.FAMILIAR)")
    FamiliarDTO toDto(Familiar familiar);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contra", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    Familiar toEntity(FamiliarDTO dto);

    List<FamiliarDTO> toDtoList(List<Familiar> familiares);
}
