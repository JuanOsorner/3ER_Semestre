package com.example.familia_api.servicios;

import com.example.familia_api.modelos.dto.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Este servicio SIMULA la obtención de datos de otros módulos (Académico, Bienestar, etc.).
 * En una aplicación real, haría llamadas a otras APIs o bases de datos.
 */
@Service
public class MockAcademicoServicio {

    public PerfilEstudianteDTO getPerfilEstudiante(Long idEstudiante) {
        PerfilEstudianteDTO perfil = new PerfilEstudianteDTO();
        perfil.setNombreCompleto("Juan Pérez González");
        perfil.setCodigoEstudiante("20251020010");
        perfil.setProgramaAcademico("Ingeniería de Software");
        perfil.setSemestre(4);
        perfil.setJornada("Diurna");
        perfil.setFotoUrl("https://example.com/foto.jpg");
        return perfil;
    }

    public List<MateriaNotaDTO> getNotasEstudiante(Long idEstudiante) {
        MateriaNotaDTO calculo = new MateriaNotaDTO();
        calculo.setNombreMateria("Cálculo Diferencial");
        calculo.setCalificacionFinal(4.5);
        calculo.setCortes(List.of(4.2, 4.8, 4.5));

        MateriaNotaDTO poo = new MateriaNotaDTO();
        poo.setNombreMateria("Programación Orientada a Objetos");
        poo.setCalificacionFinal(3.8);
        poo.setCortes(List.of(3.5, 4.0, 3.9));

        return List.of(calculo, poo);
    }

    public AsistenciaDTO getAsistenciaEstudiante(Long idEstudiante) {
        AsistenciaDTO asistencia = new AsistenciaDTO();
        asistencia.setMateria("Todas");
        asistencia.setPorcentajeAsistencia(92);
        asistencia.setTotalFallas(6);
        return asistencia;
    }

    public List<AlertaAcademicaDTO> getAlertasAcademicas(Long idEstudiante) {
        AlertaAcademicaDTO alerta = new AlertaAcademicaDTO();
        alerta.setMateria("Bases de Datos");
        alerta.setTipoAlerta("Bajo Rendimiento");
        alerta.setRecomendacion("Se recomienda asistir a tutorías los días viernes.");
        alerta.setFecha(LocalDate.now().minusDays(10));
        return List.of(alerta);
    }

    public ResumenAcademicoDTO getResumenAcademico(Long idEstudiante) {
        ResumenAcademicoDTO resumen = new ResumenAcademicoDTO();
        resumen.setPromedioSemestre(4.1);
        resumen.setCreditosCursados(16);
        resumen.setAlertasActivas(1);
        resumen.setAsistenciaGeneral(92.0);
        return resumen;
    }
}