package com.example.familia_api.repositorios;

import com.example.familia_api.modelos.Familiar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFamiliarRepositorio extends JpaRepository<Familiar, Long> {

    /**
     * Busca un Familiar por su dirección de correo electrónico.
     * El correo es un campo único, por lo que devuelve un Optional.
     * @param correo El correo del familiar a buscar.
     * @return Un Optional<Familiar> que contiene al familiar si se encuentra.
     */
    Optional<Familiar> findByCorreo(String correo);

    /**
     * Lista todos los familiares asociados a un estudiante específico a través de la
     * entidad de vínculo.
     * @param estudianteId El ID del estudiante.
     * @return Una lista de Familiares vinculados al estudiante.
     */
    @Query("SELECT v.familiar FROM VinculoFamiliarEstudiante v WHERE v.estudiante.id = :estudianteId")
    List<Familiar> findFamiliaresByEstudianteId(Long estudianteId);
}