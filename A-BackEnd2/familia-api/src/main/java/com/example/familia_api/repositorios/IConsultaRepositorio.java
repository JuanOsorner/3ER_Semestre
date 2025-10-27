package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConsultaRepositorio extends JpaRepository<Consulta, Integer> {
}
