package com.example.familia_api.servicios;

import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.dto.FamiliarDTO;
import com.example.familia_api.modelos.mapas.IMapaFamiliar;
import com.example.familia_api.repositorios.IFamiliarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamiliarServicio {

    @Autowired
    private IFamiliarRepositorio familiarRepositorio;

    @Autowired
    private IMapaFamiliar mapaFamiliar;

    public FamiliarDTO guardarFamiliar(Familiar datosFamiliar) throws Exception {
        try {
            return mapaFamiliar.toDto(familiarRepositorio.save(datosFamiliar));
        } catch (Exception error) {
            throw new Exception("Error al guardar el familiar: " + error.getMessage());
        }
    }

    public FamiliarDTO buscarFamiliarPorId(Integer id) throws Exception {
        try {
            Optional<Familiar> familiarEncontrado = familiarRepositorio.findById(id);
            if (familiarEncontrado.isPresent()) {
                return mapaFamiliar.toDto(familiarEncontrado.get());
            } else {
                throw new Exception("Familiar no encontrado");
            }
        } catch (Exception error) {
            throw new Exception("Error al buscar el familiar: " + error.getMessage());
        }
    }

    public List<FamiliarDTO> buscarTodosLosFamiliares() throws Exception {
        try {
            return mapaFamiliar.toDtoList(familiarRepositorio.findAll());
        } catch (Exception error) {
            throw new Exception("Error al buscar todos los familiares: " + error.getMessage());
        }
    }
}
