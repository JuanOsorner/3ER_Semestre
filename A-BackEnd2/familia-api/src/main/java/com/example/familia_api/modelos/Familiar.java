package com.example.familia_api.modelos;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "familiares")
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String correo;

    private String telefono;

    private String parentesco;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "familiar")
    private List<VinculoFamiliarEstudiante> vinculos;

    public Familiar() {
    }

    public Familiar(Long id, String nombre, String apellido, String correo, String telefono, String parentesco, Usuario usuario, List<VinculoFamiliarEstudiante> vinculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.parentesco = parentesco;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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