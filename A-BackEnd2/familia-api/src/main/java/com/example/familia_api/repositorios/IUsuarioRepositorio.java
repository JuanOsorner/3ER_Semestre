package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    // Este repositorio extiende JpaRepository, lo que automáticamente proporciona
    // métodos CRUD básicos (save, findById, findAll, delete, etc.) para la entidad Usuario.
    // No es necesario declararlos explícitamente aquí.

    // Se añade un método derivado de consulta para buscar un Usuario por su correo.
    // Spring Data JPA infiere la consulta SQL a partir del nombre del método.
    Optional<Usuario> findByCorreo(String correo);
}
