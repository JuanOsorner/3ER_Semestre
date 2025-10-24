package com.example.familia_api.modelos.dto;

import java.time.LocalDateTime;

public class AccesoPerfilDTO {
    private Long id;
    private Long familiarId;
    private String nombreFamiliar;
    private Long estudianteId;
    private String nombreEstudiante;
    private LocalDateTime fechaHora;

    public AccesoPerfilDTO(Long id, Long familiarId, String nombreFamiliar, Long estudianteId, String nombreEstudiante, LocalDateTime fechaHora) {
        this.id = id;
        this.familiarId = familiarId;
        this.nombreFamiliar = nombreFamiliar;
        this.estudianteId = estudianteId;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaHora = fechaHora;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFamiliarId() {
        return familiarId;
    }

    public void setFamiliarId(Long familiarId) {
        this.familiarId = familiarId;
    }

    public String getNombreFamiliar() {
        return nombreFamiliar;
    }

    public void setNombreFamiliar(String nombreFamiliar) {
        this.nombreFamiliar = nombreFamiliar;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
