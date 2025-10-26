package com.example.familia_api.modelos.dto;

public class VinculoDTO {

    private Integer id;
    private Integer estudianteId;
    private Integer familiarId;
    private String parentesco;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getFamiliarId() {
        return familiarId;
    }

    public void setFamiliarId(Integer familiarId) {
        this.familiarId = familiarId;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
