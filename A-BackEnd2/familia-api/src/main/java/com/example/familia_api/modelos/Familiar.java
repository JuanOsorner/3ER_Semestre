package com.example.familia_api.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Familiares")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Familiar extends Usuario {

    // Por ahora, esta tabla no tiene campos adicionales,
    // pero está lista para crecer en el futuro.
    // Ejemplo: private String telefonoEmergencia;

    // Constructores

    public Familiar() {
    }

    public Familiar(String nombre, String correo, String contra) {
        super(nombre, correo, contra);
    }
}
