package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConsultaRepositorio extends JpaRepository<Consulta, Integer> {
    // Este repositorio extiende JpaRepository, lo que automáticamente proporciona
    // métodos CRUD básicos (save, findById, findAll, delete, etc.) para la entidad Consulta.
    // No es necesario declararlos explícitamente aquí.

    // El método obtenerFrecuenciaDeConsultas() ha sido eliminado ya que la funcionalidad de analíticas
    // asociada a él ya no es necesaria.
}
