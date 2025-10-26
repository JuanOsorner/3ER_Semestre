package com.example.familia_api.modelos.mapas;

import com.example.familia_api.ayudas.Rol;
import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.modelos.dto.EstudianteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaEstudiante {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "correo", target = "correo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "programa", target = "programa")
    @Mapping(source = "semestre", target = "semestre")
    @Mapping(source = "promedio", target = "promedio")
    @Mapping(target = "rol", expression = "java(com.example.familia_api.ayudas.Rol.ESTUDIANTE)")
    EstudianteDTO toDto(Estudiante estudiante);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contra", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    Estudiante toEntity(EstudianteDTO dto);

    List<EstudianteDTO> toDtoList(List<Estudiante> estudiantes);
}
