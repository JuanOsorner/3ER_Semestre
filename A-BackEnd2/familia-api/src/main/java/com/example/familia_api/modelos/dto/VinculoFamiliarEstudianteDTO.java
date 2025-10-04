package com.example.familia_api.modelos.dto;

import jakarta.validation.constraints.NotNull;

public class VinculoFamiliarEstudianteDTO {

    @NotNull(message = "El ID del familiar es obligatorio")
    private Long idFamiliar;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Long idEstudiante;

    @NotNull(message = "El campo 'autorizado' es obligatorio")
    private Boolean autorizado;

    public VinculoFamiliarEstudianteDTO() {
    }

    public VinculoFamiliarEstudianteDTO(Long idFamiliar, Long idEstudiante, Boolean autorizado) {
        this.idFamiliar = idFamiliar;
        this.idEstudiante = idEstudiante;
        this.autorizado = autorizado;
    }

    // Getters y Setters
    public Long getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(Long idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }
}