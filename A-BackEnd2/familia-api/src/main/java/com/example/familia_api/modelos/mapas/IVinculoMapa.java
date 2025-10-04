package com.example.familia_api.modelos.mapas;

import com.example.familia_api.modelos.VinculoFamiliarEstudiante;
import com.example.familia_api.modelos.dto.EstudianteAsociadoDTO;
import com.example.familia_api.modelos.dto.VinculoDetalleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVinculoMapa {

    @Mapping(source = "estudiante.nombre", target = "nombreCompleto", qualifiedByName = "nombreCompleto")
    @Mapping(source = "estudiante.programaAcademico", target = "programaAcademico")
    @Mapping(source = "estudiante.semestre", target = "semestre")
    @Mapping(source = "autorizado", target = "autorizado")
    EstudianteAsociadoDTO vinculoToEstudianteAsociadoDTO(VinculoFamiliarEstudiante vinculo);

    List<EstudianteAsociadoDTO> toEstudianteAsociadoDTOList(List<VinculoFamiliarEstudiante> vinculos);

    @Mapping(source = "id", target = "idVinculo")
    @Mapping(source = "familiar.nombre", target = "nombreFamiliar") // Asumiendo nombre completo
    @Mapping(source = "estudiante.nombre", target = "nombreEstudiante") // Asumiendo nombre completo
    VinculoDetalleDTO vinculoToVinculoDetalleDTO(VinculoFamiliarEstudiante vinculo);

    List<VinculoDetalleDTO> toVinculoDetalleDTOList(List<VinculoFamiliarEstudiante> vinculos);

    // MapStruct usa esta función para combinar nombre y apellido
    @Named("nombreCompleto")
    default String nombreCompleto(String nombre) {
        // Asumiendo que el nombre completo está en el campo nombre de Estudiante.
        // Si tuvieras nombre y apellido separados, los concatenarías aquí.
        // ej: return vinculo.getEstudiante().getNombre() + " " + vinculo.getEstudiante().getApellido();
        return nombre;
    }
}