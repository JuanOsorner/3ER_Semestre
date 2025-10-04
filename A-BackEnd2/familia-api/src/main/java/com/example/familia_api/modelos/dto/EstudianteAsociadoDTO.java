package com.example.familia_api.modelos.dto;

public class EstudianteAsociadoDTO {
    private String nombreCompleto;
    private String programaAcademico;
    private Integer semestre;
    private boolean autorizado;

    public EstudianteAsociadoDTO() {
    }

    public EstudianteAsociadoDTO(String nombreCompleto, String programaAcademico, Integer semestre, boolean autorizado) {
        this.nombreCompleto = nombreCompleto;
        this.programaAcademico = programaAcademico;
        this.semestre = semestre;
        this.autorizado = autorizado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}