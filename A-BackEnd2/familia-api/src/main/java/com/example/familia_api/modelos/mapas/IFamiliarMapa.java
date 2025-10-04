package com.example.familia_api.modelos.mapas;

import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.dto.FamiliarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IFamiliarMapa {

    IFamiliarMapa INSTANCE = Mappers.getMapper(IFamiliarMapa.class);

    // Convierte Entidad a DTO
    FamiliarDTO familiarToFamiliarDTO(Familiar familiar);

    // Convierte DTO a Entidad
    Familiar familiarDTOToFamiliar(FamiliarDTO familiarDTO);

    // Para listas
    List<FamiliarDTO> toFamiliarDTOList(List<Familiar> familiares);
}