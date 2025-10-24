package com.example.familia_api.servicios;

import com.example.familia_api.modelos.AccesoPerfil;
import com.example.familia_api.modelos.dto.AccesoPerfilDTO;
import com.example.familia_api.repositorios.AccesoPerfilRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnaliticasServicio {

    private final AccesoPerfilRepositorio accesoPerfilRepositorio;

    public AnaliticasServicio(AccesoPerfilRepositorio accesoPerfilRepositorio) {
        this.accesoPerfilRepositorio = accesoPerfilRepositorio;
    }

    public List<AccesoPerfilDTO> listarTodosLosAccesos() {
        return accesoPerfilRepositorio.findAll().stream()
                .map(this::convertirA_DTO)
                .collect(Collectors.toList());
    }

    private AccesoPerfilDTO convertirA_DTO(AccesoPerfil acceso) {
        String nombreFamiliar = acceso.getFamiliar().getNombre() + " " + acceso.getFamiliar().getApellido();
        String nombreEstudiante = acceso.getEstudiante().getNombre() + " " + acceso.getEstudiante().getApellido();

        return new AccesoPerfilDTO(
                acceso.getId(),
                acceso.getFamiliar().getId(),
                nombreFamiliar,
                acceso.getEstudiante().getId(),
                nombreEstudiante,
                acceso.getFechaHora()
        );
    }
}
