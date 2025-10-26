package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificacionRepositorio extends JpaRepository<Notificacion, Integer> {
    // Este repositorio extiende JpaRepository, lo que automáticamente proporciona
    // métodos CRUD básicos (save, findById, findAll, delete, etc.) para la entidad Notificacion.
    // No es necesario declararlos explícitamente aquí.

    // Se añade un método derivado de consulta para buscar Notificaciones por el ID del familiar.
    // Spring Data JPA infiere la consulta SQL a partir del nombre del método (findBy + NombreCampo).
    List<Notificacion> findByFamiliarId(Integer familiarId);
}
