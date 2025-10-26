package com.example.familia_api.modelos.mapas;

import com.example.familia_api.modelos.Usuario;
import com.example.familia_api.modelos.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaUsuario {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "rol", ignore = true) // Corregido: El rol se asigna en los mappers de subclase (Estudiante/Familiar)
    UsuarioDTO toDto(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contra", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    Usuario toEntity(UsuarioDTO dto);

    List<UsuarioDTO> toDtoList(List<Usuario> usuarios);
}
