package com.example.familia_api.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accesos_familiares")
public class AccesoFamiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "familiar_id", nullable = false)
    private Familiar familiar;

    @Column(name = "fecha_acceso", nullable = false)
    private LocalDateTime fechaAcceso;

    @Column(name = "accion_realizada", nullable = false)
    private String accionRealizada;

    public AccesoFamiliar() {
    }

    public AccesoFamiliar(Long id, Familiar familiar, LocalDateTime fechaAcceso, String accionRealizada) {
        this.id = id;
        this.familiar = familiar;
        this.fechaAcceso = fechaAcceso;
        this.accionRealizada = accionRealizada;
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

    public LocalDateTime getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(LocalDateTime fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public String getAccionRealizada() {
        return accionRealizada;
    }

    public void setAccionRealizada(String accionRealizada) {
        this.accionRealizada = accionRealizada;
    }
}