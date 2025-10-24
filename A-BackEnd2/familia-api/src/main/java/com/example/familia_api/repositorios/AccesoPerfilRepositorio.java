package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.AccesoPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoPerfilRepositorio extends JpaRepository<AccesoPerfil, Long> {
}
