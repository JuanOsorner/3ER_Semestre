package com.example.familia_api.modelos.dto;

import java.util.List;

public class MateriaNotaDTO {

    private String nombreMateria;
    private double calificacionFinal;
    private List<Double> cortes; // [corte1, corte2, corte3]

    public MateriaNotaDTO() {
    }

    public MateriaNotaDTO(String nombreMateria, double calificacionFinal, List<Double> cortes) {
        this.nombreMateria = nombreMateria;
        this.calificacionFinal = calificacionFinal;
        this.cortes = cortes;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public double getCalificacionFinal() {
        return calificacionFinal;
    }

    public void setCalificacionFinal(double calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }

    public List<Double> getCortes() {
        return cortes;
    }

    public void setCortes(List<Double> cortes) {
        this.cortes = cortes;
    }
}