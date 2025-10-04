package com.example.familia_api.servicios;

import com.example.familia_api.modelos.dto.*;
import com.example.familia_api.repositorios.IVinculoFamiliarEstudianteRepositorio;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaEstudianteServicio {

    private final IVinculoFamiliarEstudianteRepositorio vinculoRepositorio;
    private final MockAcademicoServicio mockAcademicoServicio;

    public ConsultaEstudianteServicio(IVinculoFamiliarEstudianteRepositorio vinculoRepositorio, MockAcademicoServicio mockAcademicoServicio) {
        this.vinculoRepositorio = vinculoRepositorio;
        this.mockAcademicoServicio = mockAcademicoServicio;
    }

    /**
     * Método central de seguridad. Valida si un familiar tiene un vínculo autorizado con un estudiante.
     */
    private void validarVinculoAutorizado(Long idFamiliar, Long idEstudiante) {
        boolean esValido = vinculoRepositorio.findByFamiliarId(idFamiliar).stream()
                .anyMatch(vinculo -> vinculo.getEstudiante().getId().equals(idEstudiante) && vinculo.isAutorizado());

        if (!esValido) {
            throw new AccessDeniedException("El familiar no tiene un vínculo autorizado con este estudiante.");
        }
    }

    public PerfilEstudianteDTO consultarPerfil(Long idFamiliar, Long idEstudiante) {
        validarVinculoAutorizado(idFamiliar, idEstudiante);
        return mockAcademicoServicio.getPerfilEstudiante(idEstudiante);
    }

    public List<MateriaNotaDTO> consultarNotas(Long idFamiliar, Long idEstudiante) {
        validarVinculoAutorizado(idFamiliar, idEstudiante);
        return mockAcademicoServicio.getNotasEstudiante(idEstudiante);
    }

    public AsistenciaDTO consultarAsistencia(Long idFamiliar, Long idEstudiante) {
        validarVinculoAutorizado(idFamiliar, idEstudiante);
        return mockAcademicoServicio.getAsistenciaEstudiante(idEstudiante);
    }

    public List<AlertaAcademicaDTO> consultarAlertas(Long idFamiliar, Long idEstudiante) {
        validarVinculoAutorizado(idFamiliar, idEstudiante);
        return mockAcademicoServicio.getAlertasAcademicas(idEstudiante);
    }

    public ResumenAcademicoDTO consultarResumen(Long idFamiliar, Long idEstudiante) {
        validarVinculoAutorizado(idFamiliar, idEstudiante);
        return mockAcademicoServicio.getResumenAcademico(idEstudiante);
    }
}