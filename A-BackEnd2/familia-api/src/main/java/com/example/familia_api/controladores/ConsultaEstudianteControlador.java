package com.example.familia_api.controladores;

import com.example.familia_api.modelos.dto.*;
import com.example.familia_api.servicios.ConsultaEstudianteServicio;
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

    public ConsultaEstudianteControlador(ConsultaEstudianteServicio consultaServicio) {
        this.consultaServicio = consultaServicio;
    }

    @GetMapping("/perfil") // HU09
    public ResponseEntity<PerfilEstudianteDTO> getPerfil(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        return ResponseEntity.ok(consultaServicio.consultarPerfil(idFamiliar, idEstudiante));
    }

    @GetMapping("/notas") // HU10
    public ResponseEntity<List<MateriaNotaDTO>> getNotas(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        return ResponseEntity.ok(consultaServicio.consultarNotas(idFamiliar, idEstudiante));
    }

    @GetMapping("/asistencia") // HU11
    public ResponseEntity<AsistenciaDTO> getAsistencia(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        return ResponseEntity.ok(consultaServicio.consultarAsistencia(idFamiliar, idEstudiante));
    }

    @GetMapping("/alertas-academicas") // HU12
    public ResponseEntity<List<AlertaAcademicaDTO>> getAlertas(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        return ResponseEntity.ok(consultaServicio.consultarAlertas(idFamiliar, idEstudiante));
    }

    @GetMapping("/resumen-academico") // HU19
    public ResponseEntity<ResumenAcademicoDTO> getResumen(@PathVariable Long idFamiliar, @PathVariable Long idEstudiante) {
        return ResponseEntity.ok(consultaServicio.consultarResumen(idFamiliar, idEstudiante));
    }
}