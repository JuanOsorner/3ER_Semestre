package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
}