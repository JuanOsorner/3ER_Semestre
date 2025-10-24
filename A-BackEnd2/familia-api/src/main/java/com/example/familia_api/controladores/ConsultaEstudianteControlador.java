package com.example.familia_api.controladores;

import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.dto.*;
import com.example.familia_api.servicios.AccesoPerfilServicio;
import com.example.familia_api.servicios.ConsultaEstudianteServicio;
import com.example.familia_api.servicios.EstudianteServicio;
import com.example.familia_api.servicios.FamiliarServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/familiares/{idFamiliar}/estudiantes/{idEstudiante}")
public class ConsultaEstudianteControlador {

    private final ConsultaEstudianteServicio consultaServicio;
    private final AccesoPerfilServicio accesoPerfilServicio;
    private final FamiliarServicio familiarServicio;
    private final EstudianteServicio estudianteServicio;


    public ConsultaEstudianteControlador(ConsultaEstudianteServicio consultaServicio, AccesoPerfilServicio accesoPerfilServicio, FamiliarServicio familiarServicio, EstudianteServicio estudianteServicio) {
        this.consultaServicio = consultaServicio;
        this.accesoPerfilServicio = accesoPerfilServicio;
        this.familiarServicio = familiarServicio;
        this.estudianteServicio = estudianteServicio;
    }

    @GetMapping("/perfil") // HU09
    public ResponseEntity<?> getPerfil(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        try {
            Familiar familiar = familiarServicio.buscarEntidadPorId(idFamiliar);
            Estudiante estudiante = estudianteServicio.buscarPorId(idEstudiante);
            accesoPerfilServicio.registrarAcceso(familiar, estudiante);
            PerfilEstudianteDTO perfil = consultaServicio.consultarPerfil(idFamiliar, idEstudiante);
            return ResponseEntity.ok(perfil);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }

    @GetMapping("/notas") // HU10
    public ResponseEntity<List<MateriaNotaDTO>> getNotas(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        try {
            return ResponseEntity.ok(consultaServicio.consultarNotas(idFamiliar, idEstudiante));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/asistencia") // HU11
    public ResponseEntity<AsistenciaDTO> getAsistencia(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        try {
            return ResponseEntity.ok(consultaServicio.consultarAsistencia(idFamiliar, idEstudiante));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/alertas-academicas") // HU12
    public ResponseEntity<List<AlertaAcademicaDTO>> getAlertas(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        try {
            return ResponseEntity.ok(consultaServicio.consultarAlertas(idFamiliar, idEstudiante));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/resumen-academico") // HU19
    public ResponseEntity<ResumenAcademicoDTO> getResumen(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        try {
            return ResponseEntity.ok(consultaServicio.consultarResumen(idFamiliar, idEstudiante));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
