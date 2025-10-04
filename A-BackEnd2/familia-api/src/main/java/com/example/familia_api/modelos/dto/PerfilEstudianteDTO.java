package com.example.familia_api.modelos.dto;

public class PerfilEstudianteDTO {

    private String nombreCompleto;
    private String codigoEstudiante;
    private String programaAcademico;
    private int semestre;
    private String jornada;
    private String fotoUrl;

    public PerfilEstudianteDTO() {
    }

    public PerfilEstudianteDTO(String nombreCompleto, String codigoEstudiante, String programaAcademico, int semestre, String jornada, String fotoUrl) {
        this.nombreCompleto = nombreCompleto;
        this.codigoEstudiante = codigoEstudiante;
        this.programaAcademico = programaAcademico;
        this.semestre = semestre;
        this.jornada = jornada;
        this.fotoUrl = fotoUrl;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}