package com.example.familia_api.modelos.dto;

import java.time.LocalDate;

public class AlertaAcademicaDTO {

    private String materia;
    private String tipoAlerta; // Ej: "Bajo Rendimiento", "Riesgo de Pérdida por Fallas"
    private String recomendacion;
    private LocalDate fecha;

    public AlertaAcademicaDTO() {
    }

    public AlertaAcademicaDTO(String materia, String tipoAlerta, String recomendacion, LocalDate fecha) {
        this.materia = materia;
        this.tipoAlerta = tipoAlerta;
        this.recomendacion = recomendacion;
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}