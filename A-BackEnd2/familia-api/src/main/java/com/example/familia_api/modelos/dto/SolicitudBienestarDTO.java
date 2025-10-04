package com.example.familia_api.modelos.dto;

import java.time.LocalDate;

public class SolicitudBienestarDTO {

    private String tipoSolicitud; // Ej: "Apoyo Psicológico", "Beca Socioeconómica"
    private String estado; // Ej: "En Revisión", "Aprobada"
    private LocalDate fechaSolicitud;

    public SolicitudBienestarDTO() {
    }

    public SolicitudBienestarDTO(String tipoSolicitud, String estado, LocalDate fechaSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}