package com.example.familia_api.modelos;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "codigo_estudiante", nullable = false, unique = true)
    private String codigoEstudiante;

    private String programaAcademico;

    // --- CAMPO QUE FALTA ---
    @Column(name = "semestre")
    private Integer semestre;
    // -----------------------

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante")
    private List<VinculoFamiliarEstudiante> vinculos;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, String apellido, String codigoEstudiante, String programaAcademico, Integer semestre, Usuario usuario, List<VinculoFamiliarEstudiante> vinculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoEstudiante = codigoEstudiante;
        this.programaAcademico = programaAcademico;
        this.semestre = semestre;
        this.usuario = usuario;
        this.vinculos = vinculos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<VinculoFamiliarEstudiante> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<VinculoFamiliarEstudiante> vinculos) {
        this.vinculos = vinculos;
    }
}