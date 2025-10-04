package com.example.familia_api.modelos.dto;

public class ResumenAcademicoDTO {

    private double promedioSemestre;
    private int creditosCursados;
    private int alertasActivas;
    private double asistenciaGeneral; // en porcentaje

    public ResumenAcademicoDTO() {
    }

    public ResumenAcademicoDTO(double promedioSemestre, int creditosCursados, int alertasActivas, double asistenciaGeneral) {
        this.promedioSemestre = promedioSemestre;
        this.creditosCursados = creditosCursados;
        this.alertasActivas = alertasActivas;
        this.asistenciaGeneral = asistenciaGeneral;
    }

    public double getPromedioSemestre() {
        return promedioSemestre;
    }

    public void setPromedioSemestre(double promedioSemestre) {
        this.promedioSemestre = promedioSemestre;
    }

    public int getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(int creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    public int getAlertasActivas() {
        return alertasActivas;
    }

    public void setAlertasActivas(int alertasActivas) {
        this.alertasActivas = alertasActivas;
    }

    public double getAsistenciaGeneral() {
        return asistenciaGeneral;
    }

    public void setAsistenciaGeneral(double asistenciaGeneral) {
        this.asistenciaGeneral = asistenciaGeneral;
    }
}