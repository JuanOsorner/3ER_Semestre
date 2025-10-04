package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.VinculoFamiliarEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVinculoFamiliarEstudianteRepositorio extends JpaRepository<VinculoFamiliarEstudiante, Long> {

    List<VinculoFamiliarEstudiante> findByEstudianteId(Long estudianteId);

    List<VinculoFamiliarEstudiante> findByFamiliarId(Long familiarId);
}