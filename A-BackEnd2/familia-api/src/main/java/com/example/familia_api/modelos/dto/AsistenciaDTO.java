package com.example.familia_api.modelos.dto;

public class AsistenciaDTO {

    private String materia;
    private int porcentajeAsistencia;
    private int totalFallas;

    public AsistenciaDTO() {
    }

    public AsistenciaDTO(String materia, int porcentajeAsistencia, int totalFallas) {
        this.materia = materia;
        this.porcentajeAsistencia = porcentajeAsistencia;
        this.totalFallas = totalFallas;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public void setPorcentajeAsistencia(int porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    public int getTotalFallas() {
        return totalFallas;
    }

    public void setTotalFallas(int totalFallas) {
        this.totalFallas = totalFallas;
    }
}