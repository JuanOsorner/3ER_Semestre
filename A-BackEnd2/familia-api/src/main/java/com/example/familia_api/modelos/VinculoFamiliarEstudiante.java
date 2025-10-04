package com.example.familia_api.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "vinculos_familiares_estudiantes")
public class VinculoFamiliarEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "familiar_id", nullable = false)
    private Familiar familiar;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @Column(nullable = false)
    private boolean autorizado;

    public VinculoFamiliarEstudiante() {
    }

    public VinculoFamiliarEstudiante(Long id, Familiar familiar, Estudiante estudiante, boolean autorizado) {
        this.id = id;
        this.familiar = familiar;
        this.estudiante = estudiante;
        this.autorizado = autorizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}