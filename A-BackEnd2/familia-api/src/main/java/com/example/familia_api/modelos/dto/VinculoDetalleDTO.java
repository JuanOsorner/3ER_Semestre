package com.example.familia_api.modelos.dto;

public class VinculoDetalleDTO {
    private Long idVinculo;
    private String nombreFamiliar;
    private String nombreEstudiante;
    private boolean autorizado;

    public VinculoDetalleDTO() {
    }

    public VinculoDetalleDTO(Long idVinculo, String nombreFamiliar, String nombreEstudiante, boolean autorizado) {
        this.idVinculo = idVinculo;
        this.nombreFamiliar = nombreFamiliar;
        this.nombreEstudiante = nombreEstudiante;
        this.autorizado = autorizado;
    }

    public Long getIdVinculo() {
        return idVinculo;
    }

    public void setIdVinculo(Long idVinculo) {
        this.idVinculo = idVinculo;
    }

    public String getNombreFamiliar() {
        return nombreFamiliar;
    }

    public void setNombreFamiliar(String nombreFamiliar) {
        this.nombreFamiliar = nombreFamiliar;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}